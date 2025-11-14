package proyecto.de.poo115.dao;

import proyecto.de.poo115.conexion.ConexionMongoDB;
import proyecto.de.poo115.modelos.Empleado; // Importa tu POJO arreglado
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    
    private final MongoCollection<Document> coleccion;

    public EmpleadoDAO() {
        MongoDatabase db = ConexionMongoDB.getInstancia().getDatabase();
        this.coleccion = db.getCollection("empleados");
    }

    // CREATE
    public void insertar(Empleado e) {
        Document doc = new Document("codigo", e.getCodigo())
                .append("nombre", e.getNombre())
                .append("apellido", e.getApellido())
                .append("cargo", e.getCargo())
                .append("salario", e.getSalario())
                .append("contratos", e.getContratos()); // Guarda la lista de contratos
        coleccion.insertOne(doc);
    }

    // READ
    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        for (Document doc : coleccion.find()) {
            // Usamos el constructor vacío y los setters (por eso quitaste 'final')
            Empleado e = new Empleado();
            e.setId(doc.getObjectId("_id").toString()); // Guarda el ID de Mongo
            e.setCodigo(doc.getInteger("codigo"));
            e.setNombre(doc.getString("nombre"));
            e.setApellido(doc.getString("apellido"));
            e.setCargo(doc.getString("cargo"));
            e.setSalario(doc.getDouble("salario"));
            // (Opcional: cargar la lista de contratos si existe)
            // e.setContratos(doc.get("contratos", ArrayList.class));
            lista.add(e);
        }
        return lista;
    }

    // DELETE
    public void eliminar(String id) {
        coleccion.deleteOne(new Document("_id", new ObjectId(id)));
    }

    // UPDATE
    public void actualizar(Empleado e) {
        Document filtro = new Document("_id", new ObjectId(e.getId()));
        Document cambios = new Document("$set", new Document("codigo", e.getCodigo())
                .append("nombre", e.getNombre())
                .append("apellido", e.getApellido())
                .append("cargo", e.getCargo())
                .append("salario", e.getSalario()));
                // (No actualizamos la lista de contratos aquí, eso es otra lógica)
        coleccion.updateOne(filtro, cambios);
    }
}