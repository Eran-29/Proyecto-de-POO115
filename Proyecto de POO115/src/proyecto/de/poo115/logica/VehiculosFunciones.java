
package proyecto.de.poo115.logica;
import proyecto.de.poo115.conección.dao.VehiculosConeccionDAO;
import proyecto.de.poo115.modelos.Vehiculos;
import java.util.List;


public class VehiculosFunciones {
    private final VehiculosConeccionDAO dao;

    public VehiculosFunciones(VehiculosConeccionDAO dao) {
        this.dao = dao;
    }

    public void registrarVehiculo(Vehiculos v) {
        if (v.getMarca().isEmpty() || v.getModelo().isEmpty()) {
            throw new IllegalArgumentException("Marca y modelo son obligatorios");
        }
        dao.insertar(v);
    }

    public List<Vehiculos> obtenerTodos() {
        return dao.listar();
    }

    public void eliminarVehiculo(String id) {
        dao.eliminar(id);
    }

    public void actualizarVehiculo(Vehiculos v) {
        dao.actualizar(v);
    }
    
}
