package proyecto.de.poo115.logica;

import proyecto.de.poo115.dao.AlquilerDAO;
import proyecto.de.poo115.modelos.Alquiler;
import java.util.List;

// Importamos la clase Date de Java para hacer comparaciones
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AlquilerFunciones {
    
    private final AlquilerDAO dao;
    // Formato de fecha que usaremos para convertir Strings a Date
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy"); 

    public AlquilerFunciones(AlquilerDAO dao) {
        this.dao = dao;
    }

    public void registrarAlquiler(Alquiler a) {
        
        if (a.getIdContrato().isEmpty() || a.getIdCliente().isEmpty() || a.getIdVehiculo().isEmpty()) {
            throw new IllegalArgumentException("ID de Contrato, Cliente y Vehículo son obligatorios.");
        }
        
        try {
            Date inicio = DATE_FORMAT.parse(a.getFechaInicio());
            Date fin = DATE_FORMAT.parse(a.getFechaFin());
            
            // 1.La fecha de fin NO puede ser antes que la de inicio.
            if (fin.before(inicio)) {
                throw new IllegalArgumentException("La fecha de finalización no puede ser anterior a la de inicio.");
            }
            
            // 2.Cálculo del Total 
            long diff = fin.getTime() - inicio.getTime(); // Diferencia en milisegundos
            long dias = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            
            // Si son el mismo día, cuenta 1 día. Si hay diferencia, cuenta los días.
            dias = (dias == 0) ? 1 : dias; 
            
            // el precio/día del VehiculoDAO.*
            double precioPorDia = 40.0; 
             a.setTotalPagar(precioPorDia * dias);
            
        } catch (java.text.ParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Use DD/MM/AAAA.");
        }

        // Si todas las validaciones pasan
        dao.insertar(a);
    }

    public List<Alquiler> obtenerTodos() {
        return dao.listar();
    }

    public void eliminarAlquiler(String id) {
        // al "eliminar" un alquiler, el vehículo pasaría a "disponible".
        dao.eliminar(id);
    }

    public void actualizarAlquiler(Alquiler a) {
        // Se pueden re-usar las validaciones de Fechas/IDs
        registrarAlquiler(a);
        dao.actualizar(a);
    }

    public void finalizarAlquiler(String idAlquilerSeleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}