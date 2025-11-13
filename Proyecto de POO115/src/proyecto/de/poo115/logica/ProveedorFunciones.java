package proyecto.de.poo115.logica;

import proyecto.de.poo115.conección.dao.ProveedorDAO;
import proyecto.de.poo115.modelos.Proveedor;
import java.util.List;

public class ProveedorFunciones {
    
    private final ProveedorDAO dao;

    public ProveedorFunciones(ProveedorDAO dao) {
        this.dao = dao;
    }

    public void registrarProveedor(Proveedor p) {
        // Validación: Campos ID, Nombre y Teléfono obligatorios
        if (p.getIdProveedor().isEmpty() || p.getNombre().isEmpty() || p.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("El ID, Nombre y Teléfono del proveedor son obligatorios.");
        }
        dao.insertar(p);
    }

    public List<Proveedor> obtenerTodos() {
        return dao.listar();
    }

    public void eliminarProveedor(String id) {
        dao.eliminar(id);
    }

    public void actualizarProveedor(Proveedor p) {
        if (p.getIdProveedor().isEmpty() || p.getNombre().isEmpty() || p.getTelefono().isEmpty()) {
            throw new IllegalArgumentException("El ID, Nombre y Teléfono del proveedor son obligatorios.");
        }
        dao.actualizar(p);
    }
}
