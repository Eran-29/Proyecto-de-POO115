
package proyecto.de.poo115.logica;

import proyecto.de.poo115.dao.ClienteDAO;
import proyecto.de.poo115.modelos.Cliente;
import java.util.List;
import java.util.regex.Pattern; // Para validar email


//clase encargada de las funciones y validaciones de datos del cliente
public class ClienteFunciones {
    
    private final ClienteDAO dao;
    
    // === CONSTANTES DE VALIDACIÓN ===

    // para correo
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
    );
    
    // Para nombres y apellidos
    private static final Pattern NOMBRE_PATTERN = Pattern.compile(
            "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s']+$"
    );
    
    // Para Teléfono de El Salvador (8 dígitos, empieza con 2, 6 o 7)
    private static final Pattern TELEFONO_SV_PATTERN = Pattern.compile(
            "^[267][0-9]{7}$"
    );
    
    // Para formato de DUI de El Salvador (8 dígitos - 1 dígito)
    private static final Pattern DUI_FORMATO_PATTERN = Pattern.compile(
            "^[0-9]{8}-[0-9]$"
    );

    // Para formato de Licencia de El Salvador (ej. 0101-150290-101-1)
    private static final Pattern LICENCIA_SV_PATTERN = Pattern.compile(
            "^[0-9]{4}-[0-9]{6}-[0-9]{3}-[0-9]$"
    );
    
    // Asumo que tienes tu 'dao'
     // Reemplaza ClienteDAO con tu clase real
    public ClienteFunciones(ClienteDAO dao) {
        this.dao = dao;
    }

    public void registrarCliente(Cliente c) {
        // 1. Validación de campos obligatorios 
        
        if (esNuloOEnBlanco(c.getIdentificacion()) || 
            esNuloOEnBlanco(c.getNombre()) || 
            esNuloOEnBlanco(c.getApellido())) {
            throw new IllegalArgumentException("La identificación, nombre y apellido son obligatorios");
        }

        // 2. Validación de formato de Nombre y Apellido
        if (!NOMBRE_PATTERN.matcher(c.getNombre()).matches()) {
            throw new IllegalArgumentException("El nombre contiene caracteres no válidos");
        }
        if (!NOMBRE_PATTERN.matcher(c.getApellido()).matches()) {
            throw new IllegalArgumentException("El apellido contiene caracteres no válidos");
        }

        // 3. Validación de Email (asumiendo que es obligatorio)
        // Si el email es opcional, la lógica cambia un poco*
        if (esNuloOEnBlanco(c.getCorreo()) || !EMAIL_PATTERN.matcher(c.getCorreo()).matches()) {
            throw new IllegalArgumentException("El correo es obligatorio y debe tener un formato válido");
        }
        
        // 4. Validación de DUI
        // No solo validamos el formato, sino que el número sea matemáticamente correcto.
        if (!esDuiValido(c.getIdentificacion())) {
            throw new IllegalArgumentException("El DUI no es válido. Debe tener el formato 00000000-0 y ser un número válido.");
        }
        
        // 5. Validación de Teléfono 
        // Asumimos que el teléfono es OPCIONAL.
        // Si no está en blanco, lo validamos.
        if (!esNuloOEnBlanco(c.getTelefono())) {
            // Limpiamos el teléfono (quitamos guiones o espacios)
            String telLimpio = c.getTelefono().replaceAll("[\\s-]+", "");
            
            if (!TELEFONO_SV_PATTERN.matcher(telLimpio).matches()) {
                throw new IllegalArgumentException("El teléfono debe ser un número válido de 8 dígitos de El Salvador (iniciando con 2, 6 o 7)");
            }
        }

        // 6. Validación de Licencia de Conducir de El Salvador
        if (!esNuloOEnBlanco(c.getLicencia())) {
            if (!LICENCIA_SV_PATTERN.matcher(c.getLicencia()).matches()) {
                throw new IllegalArgumentException("El formato de la licencia de conducir no es válido (debe ser NNNN-NNNNNN-NNN-N)");
            }
        dao.insertar(c);
    }
        
    }    
// MÉTODOS DE AYUDA (HELPERS)
    /**
     * Verifica si una cadena es nula, vacía o solo espacios en blanco.
     */
    private boolean esNuloOEnBlanco(String str) {
        return str == null || str.trim().isEmpty();
    }

    /**
     * Valida un DUI , incluyendo el dígito verificador.
     */
    private boolean esDuiValido(String dui) {
        if (esNuloOEnBlanco(dui) || !DUI_FORMATO_PATTERN.matcher(dui).matches()) {
            return false; // No cumple con el formato NNNNNNNN-N
        }

        try {
            String numeros = dui.substring(0, 8); // "00000000"
            int digitoVerificador = Integer.parseInt(dui.substring(9)); // "0"

            int suma = 0;
            // Algoritmo Módulo 10: Se multiplica cada dígito por (9, 8, 7, 6, 5, 4, 3, 2)
            for (int i = 0; i < numeros.length(); i++) {
                suma += Character.getNumericValue(numeros.charAt(i)) * (9 - i);
            }
            
            // 1. Obtenemos el residuo de la suma entre 10
            int residuo = suma % 10;
            
            // 2. A 10 le restamos el residuo. Si el residuo es 0, el dígito es 0.
            int digitoCalculado = (residuo == 0) ? 0 : (10 - residuo);
            
            // Comparamos el dígito calculado con el dígito verificador del DUI
            return digitoVerificador == digitoCalculado;
            
        } catch (Exception e) {
            // Si algo falla (ej. parseo), no es válido
            return false;
        }
    }

    public List<Cliente> obtenerTodos() {
        return dao.listar();
    }

    public void eliminarCliente(String id) {
        dao.eliminar(id);
    }

    public void actualizarCliente(Cliente c) {
        // Re-usamos las mismas validaciones
        if (c.getIdentificacion().isEmpty() || c.getNombre().isEmpty() || c.getApellido().isEmpty()) {
            throw new IllegalArgumentException("La identificación, nombre y apellido son obligatorios");
        }
        if (!EMAIL_PATTERN.matcher(c.getCorreo()).matches()) {
            throw new IllegalArgumentException("El formato del correo electrónico no es válido");
        }
        
        dao.actualizar(c);
    }

    public void editarCliente(Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}