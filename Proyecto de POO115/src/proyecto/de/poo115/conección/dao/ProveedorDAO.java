package proyecto.de.poo115.conección.dao;

import proyecto.de.poo115.modelos.ConexionMongoDB;
import proyecto.de.poo115.modelos.Proveedor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    
    private final MongoCollection<Document> coleccion;

    public ProveedorDAO() {
        MongoDatabase db = ConexionMongoDB.getInstancia().getDatabase();
        this.coleccion = db.getCollection("proveedores");
    }

    // CREATE
    public void insertar(Proveedor p) {
        Document doc = new Document("idProveedor", p.getIdProveedor())
                .append("nombre", p.getNombre())
                .append("tipoServicio", p.getTipoServicio())
                .append("telefono", p.getTelefono())
                .append("direccion", p.getDireccion())
                .append("vehiculoAsociado", p.getVehiculoAsociado());
        coleccion.insertOne(doc);
    }

    // READ
    public List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            // El POJO de Proveedor sí tenía constructor vacío, ¡bien!
            Proveedor p = new Proveedor();
            p.setId(doc.getObjectId("_id").toString()); // ID de Mongo
            p.setIdproveedor(doc.getString("idProveedor")); // ID de negocio
            p.setNombre(doc.getString("nombre"));
            p.setTipoServicio(doc.getString("tipoServicio"));
            p.setTelefono(doc.getString("telefono"));
            p.setDireccion(doc.getString("direccion"));
            p.setVehiculoAsociado(doc.getString("vehiculoAsociado"));
            lista.add(p);
        }
        return lista;
    }

    // DELETE
    public void eliminar(String id) {
        coleccion.deleteOne(new Document("_id", new ObjectId(id)));
    }

    // UPDATE
    public void actualizar(Proveedor p) {
        Document filtro = new Document("_id", new ObjectId(p.getId()));
        Document cambios = new Document("$set", new Document("idProveedor", p.getIdProveedor())
                .append("nombre", p.getNombre())
                .append("tipoServicio", p.getTipoServicio())
                .append("telefono", p.getTelefono())
                .append("direccion", p.getDireccion())
                .append("vehiculoAsociado", p.getVehiculoAsociado()));
        coleccion.updateOne(filtro, cambios);
    }
}