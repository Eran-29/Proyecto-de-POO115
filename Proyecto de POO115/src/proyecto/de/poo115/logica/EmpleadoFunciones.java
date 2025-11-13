package proyecto.de.poo115.logica;

import proyecto.de.poo115.conección.dao.EmpleadoDAO;
import proyecto.de.poo115.modelos.Empleado;
import java.util.List;

public class EmpleadoFunciones {
    
    private final EmpleadoDAO dao;

    public EmpleadoFunciones(EmpleadoDAO dao) {
        this.dao = dao;
    }

    public void registrarEmpleado(Empleado e) {
        // Validación: Campos vacíos y Salario positivo (según el PDF)
        if (e.getNombre().isEmpty() || e.getApellido().isEmpty() || e.getCargo().isEmpty()) {
            throw new IllegalArgumentException("Nombre, apellido y cargo son obligatorios.");
        }
        
        if (e.getSalario() <= 0) {
            throw new IllegalArgumentException("El salario debe ser un número positivo.");
        }
        
        dao.insertar(e);
    }

    public List<Empleado> obtenerTodos() {
        return dao.listar();
    }

    public void eliminarEmpleado(String id) {
        dao.eliminar(id);
    }

    public void actualizarEmpleado(Empleado e) {
        // Re-usamos validaciones
        if (e.getNombre().isEmpty() || e.getApellido().isEmpty() || e.getCargo().isEmpty()) {
            throw new IllegalArgumentException("Nombre, apellido y cargo son obligatorios.");
        }
        if (e.getSalario() <= 0) {
            throw new IllegalArgumentException("El salario debe ser un número positivo.");
        }
        dao.actualizar(e);
    }
}