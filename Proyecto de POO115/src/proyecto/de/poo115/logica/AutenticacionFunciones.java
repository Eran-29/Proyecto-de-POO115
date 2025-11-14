package proyecto.de.poo115.logica;

import proyecto.de.poo115.conección.dao.EmpleadoDAO;
import proyecto.de.poo115.modelos.Empleado;
import java.util.List;

//clase para comprobar al usuario
public class AutenticacionFunciones {
    
    private EmpleadoDAO empleadoDAO;

    public AutenticacionFunciones(EmpleadoDAO dao) {
        this.empleadoDAO = dao;
    }

    /**
     * Valida si un empleado existe con ese código y apellido.
     * @param codigo El "usuario" (código de empleado)
     * @param apellido El "password" (apellido del empleado)
     * @return El objeto Empleado si es exitoso, o null si falla.
     */
    public Empleado validarLogin(String codigoStr, String apellido) {
        
        if (codigoStr.isEmpty() || apellido.isEmpty()) {
            throw new IllegalArgumentException("Código y Apellido son obligatorios.");
        }

        try {
            int codigo = Integer.parseInt(codigoStr);
            
            // método es ineficiente pero simple.
            // Trae a todos los empleados y busca en la lista.
            List<Empleado> todos = empleadoDAO.listar();
            
            for (Empleado emp : todos) {
                if (emp.getCodigo() == codigo && emp.getApellido().equalsIgnoreCase(apellido)) {
                    return emp; // ¡Éxito! Retorna el empleado
                }
            }
            
            return null; // No se encontró
            
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El código debe ser un número.");
        }
    }
}