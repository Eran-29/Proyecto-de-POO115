package proyecto.de.poo115;

// Estas son las "herramientas" que importamos del driver que bajaste
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import com.mongodb.MongoException;

public class ConexionMongoDB {

    // --- Patrón Singleton ---
    // 1. Variable estática para guardar la única instancia de esta clase
    private static ConexionMongoDB instancia;
    
    // 2. Variables para la conexión
    private MongoClient mongoClient;
    private MongoDatabase database;

    // 3. Constructor PRIVADO (esto es clave en Singleton)
    // Nadie de fuera puede crear un new ConexionMongoDB()
    private ConexionMongoDB() {
        try {
            // 4. La dirección de tu servidor local
            String connectionString = "mongodb://localhost:27017";
            
            // 5. Creamos el cliente de MongoDB
            this.mongoClient = MongoClients.create(connectionString);
            
            // 6. Obtenemos la base de datos. 
            // ¡Si no existe, Mongo la crea solo cuando insertes el primer dato!
            this.database = mongoClient.getDatabase("AlquilerAutosDB");
            
            System.out.println("¡CONEXIÓN A MONGODB EXITOSA!");
            
        } catch (MongoException e) {
            System.err.println("Error al conectar a MongoDB: " + e.getMessage());
            // (Opcional) Podrías lanzar una excepción aquí
        }
    }

    // 4. Método público estático para obtener la instancia (el "Singleton")
    // Esta es la ÚNICA forma de acceder a esta clase
    public static ConexionMongoDB getInstancia() {
        // Si la instancia aún no existe, la crea
        if (instancia == null) {
            instancia = new ConexionMongoDB();
        }
        // Si ya existe, devuelve la que ya teníamos
        return instancia;
    }

    // 5. Método público para que el resto de tu equipo (los DAO) 
    // puedan obtener la base de datos y trabajar.
    public MongoDatabase getDatabase() {
        return database;
    }

    // 6. (Opcional pero recomendado) Método para cerrar la conexión
    public void close() {
        try {
            if (mongoClient != null) {
                mongoClient.close();
                System.out.println("Conexión a MongoDB cerrada.");
            }
        } catch (MongoException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}