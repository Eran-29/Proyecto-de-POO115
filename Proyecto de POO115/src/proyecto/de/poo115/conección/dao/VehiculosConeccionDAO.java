
package proyecto.de.poo115.conección.dao; 


import proyecto.de.poo115.modelos.ConexionMongoDB; 
import proyecto.de.poo115.modelos.Vehiculos; 

// Importaciones necesarias de MongoDB
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class VehiculosConeccionDAO { 
    
    private final MongoCollection<Document> coleccion;

  
    public VehiculosConeccionDAO() {
        MongoDatabase db = ConexionMongoDB.getInstancia().getDatabase();
        this.coleccion = db.getCollection("vehiculos");
    }

    
    public void insertar(Vehiculos v) {
        Document doc = new Document("marca", v.getMarca())
                .append("modelo", v.getModelo())
                .append("anio", v.getAnio())
                .append("tipo", v.getTipo())
                .append("precioDia", v.getPrecioDia())
                .append("disponible", v.isDisponible());
        coleccion.insertOne(doc);
    }

    public List<Vehiculos> listar() {
        List<Vehiculos> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            Vehiculos v = new Vehiculos(
                    doc.getString("marca"),
                    doc.getString("modelo"),
                    doc.getInteger("anio", 0),
                    doc.getString("tipo"),
                    doc.getDouble("precioDia"),
                    doc.getBoolean("disponible", true)
            );
            v.setId(doc.getObjectId("_id").toString()); // ¡Muy bien hecho por él!
            lista.add(v);
        }
        return lista;
    }

    public void eliminar(String id) {
        coleccion.deleteOne(new Document("_id", new ObjectId(id)));
    }

    public void actualizar(Vehiculos v) {
        Document filtro = new Document("_id", new ObjectId(v.getId()));
        Document cambios = new Document("$set", new Document("marca", v.getMarca())
                .append("modelo", v.getModelo())
                .append("anio", v.getAnio())
                .append("tipo", v.getTipo())
                .append("precioDia", v.getPrecioDia())
                .append("disponible", v.isDisponible()));
        coleccion.updateOne(filtro, cambios);
    }
}