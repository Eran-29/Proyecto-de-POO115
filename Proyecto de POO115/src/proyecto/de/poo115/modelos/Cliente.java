package proyecto.de.poo115.modelos;


public class Cliente {

    private String id; // Para guardar el _id de MongoDB
    private String identificacion; // El "ID" de negocio (DUI, etc.)
    private String nombre;
    private String apellido;
    private String licencia;
    private String telefono;
    private String correo;

    // Se inicializa Constructor vacío
    public Cliente() {
    }

    // Constructor completo (sin el id de Mongo, ese se genera solo)
    public Cliente(String identificacion, String nombre, String apellido, String licencia, String telefono, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.licencia = licencia;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Getters y Setters 
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getLicencia() { return licencia;}
    public void setLicencia(String licencia) { this.licencia = licencia;}

    public String getTelefono() { return telefono;}
    public void setTelefono(String telefono) { this.telefono = telefono;}

    public String getCorreo() { return correo;}
    public void setCorreo(String correo) { this.correo = correo;}

    public Object getIdCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdCliente(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}