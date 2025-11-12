
package proyecto.de.poo115.logica;
import proyecto.de.poo115.conección.dao.VehiculoDAO;
import proyecto.de.poo115.modelos.Vehiculo;
import java.util.List;


public class VehiculoFunciones {
    private final VehiculoDAO dao;

    public VehiculoFunciones(VehiculoDAO dao) {
        this.dao = dao;
    }

    public void registrarVehiculo(Vehiculo v) {
        if (v.getMarca().isEmpty() || v.getModelo().isEmpty()) {
            throw new IllegalArgumentException("Marca y modelo son obligatorios");
        }
        dao.insertar(v);
    }

    public List<Vehiculo> obtenerTodos() {
        return dao.listar();
    }

    public void eliminarVehiculo(String id) {
        dao.eliminar(id);
    }

    public void actualizarVehiculo(Vehiculo v) {
        dao.actualizar(v);
    }
    
}
