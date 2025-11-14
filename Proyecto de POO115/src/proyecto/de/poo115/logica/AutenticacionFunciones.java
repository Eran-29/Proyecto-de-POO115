
package proyecto.de.poo115.logica;

import proyecto.de.poo115.dao.EmpleadoDAO;
import proyecto.de.poo115.modelos.Empleado;
import java.util.List;

public class AutenticacionFunciones {
    
    private EmpleadoDAO empleadoDAO;

    public AutenticacionFunciones(EmpleadoDAO dao) {
        this.empleadoDAO = dao;
    }

    public Empleado validarLogin(String codigoStr, String apellido) {
        if (codigoStr.isEmpty() || apellido.isEmpty()) {
            throw new IllegalArgumentException("Código y Apellido son obligatorios.");
        }
        try {
            int codigo = Integer.parseInt(codigoStr);
            //trae a todos los empleados y busca en la lista
            List<Empleado> todos = empleadoDAO.listar();
            for (Empleado emp : todos) {
                if (emp.getCodigo() == codigo && emp.getApellido().equalsIgnoreCase(apellido)) {
                    return emp; // ¡Éxito!Rertorna empleado
                }
            }
            return null; // No se encontró
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El código debe ser un número.");
        }
    }
}