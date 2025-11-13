package proyecto.de.poo115.conección.dao;

import proyecto.de.poo115.modelos.ConexionMongoDB;
import proyecto.de.poo115.modelos.Alquiler; // Asumiendo que lo renombraste
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDAO {
    
    private final MongoCollection<Document> coleccion;

    public AlquilerDAO() {
        MongoDatabase db = ConexionMongoDB.getInstancia().getDatabase();
        this.coleccion = db.getCollection("alquileres");
    }

    // CREATE
    public void insertar(Alquiler a) {
        Document doc = new Document("idContrato", a.getIdContrato())
                .append("idCliente", a.getIdCliente())
                .append("idVehiculo", a.getIdVehiculo())
                .append("idEmpleado", a.getIdEmpleado())
                .append("fechaInicio", a.getFechaInicio())
                .append("fechaFin", a.getFechaFin())
                .append("totalPagar", a.getTotalPagar());
        coleccion.insertOne(doc);
    }

    // READ
    public List<Alquiler> listar() {
        List<Alquiler> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            Alquiler a = new Alquiler(); // Usamos constructor vacío
            a.setId(doc.getObjectId("_id").toString()); // ID de Mongo
            a.setIdContrato(doc.getString("idContrato"));
            a.setIdCliente(doc.getString("idCliente"));
            a.setIdVehiculo(doc.getString("idVehiculo"));
            a.setIdEmpleado(doc.getString("idEmpleado"));
            a.setFechaInicio(doc.getString("fechaInicio"));
            a.setFechaFin(doc.getString("fechaFin"));
            a.setTotalPagar(doc.getDouble("totalPagar"));
            lista.add(a);
        }
        return lista;
    }

    // DELETE
    public void eliminar(String id) {
        coleccion.deleteOne(new Document("_id", new ObjectId(id)));
    }

    // UPDATE
    public void actualizar(Alquiler a) {
        Document filtro = new Document("_id", new ObjectId(a.getId()));
        Document cambios = new Document("$set", new Document("idContrato", a.getIdContrato())
                .append("idCliente", a.getIdCliente())
                .append("idVehiculo", a.getIdVehiculo())
                .append("idEmpleado", a.getIdEmpleado())
                .append("fechaInicio", a.getFechaInicio())
                .append("fechaFin", a.getFechaFin())
                .append("totalPagar", a.getTotalPagar()));
        coleccion.updateOne(filtro, cambios);
    }
}
