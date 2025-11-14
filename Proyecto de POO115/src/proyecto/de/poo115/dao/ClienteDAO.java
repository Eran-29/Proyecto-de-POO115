package proyecto.de.poo115.dao;

//importamos 
import proyecto.de.poo115.conexion.ConexionMongoDB;
import proyecto.de.poo115.modelos.Cliente; 
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

//la clase cliente que se conecta con la Base de Datos
public class ClienteDAO {
    
    private final MongoCollection<Document> coleccion;

    public ClienteDAO() {
        MongoDatabase db = ConexionMongoDB.getInstancia().getDatabase();
        // Le decimos que esta clase trabajará con la "tabla" de clientes
        this.coleccion = db.getCollection("clientes");
    }

    // metodo para crear objeto
    public void insertar(Cliente c) {
        Document doc = new Document("identificacion", c.getIdentificacion())
                .append("nombre", c.getNombre())
                .append("apellido", c.getApellido())
                .append("licencia", c.getLicencia())
                .append("telefono", c.getTelefono())
                .append("correo", c.getCorreo());
        coleccion.insertOne(doc);
    }

    // metodo para leer los datos
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            Cliente c = new Cliente(
                    doc.getString("identificacion"),
                    doc.getString("nombre"),
                    doc.getString("apellido"),
                    doc.getString("licencia"),
                    doc.getString("telefono"),
                    doc.getString("correo")
            );
            c.setId(doc.getObjectId("_id").toString()); // Guarda el ID de Mongo
            lista.add(c);
        }
        return lista;
    }

    // metodo para eliminar datos
    public void eliminar(String id) {
        coleccion.deleteOne(new Document("_id", new ObjectId(id)));
    }

    // metodo para actualizar datos
    public void actualizar(Cliente c) {
        Document filtro = new Document("_id", new ObjectId(c.getId()));
        Document cambios = new Document("$set", new Document("identificacion", c.getIdentificacion())
                .append("nombre", c.getNombre())
                .append("apellido", c.getApellido())
                .append("licencia", c.getLicencia())
                .append("telefono", c.getTelefono())
                .append("correo", c.getCorreo()));
        coleccion.updateOne(filtro, cambios);
    }
}
