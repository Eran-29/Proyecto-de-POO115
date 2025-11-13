package proyecto.de.poo115.modelos;

public class Proveedor {

    // 1. Campo para MongoDB
    private String id;
    
    // Atributos del proveedor
    private String idProveedor;
    private String nombre;
    private String tipoServicio; 
    private String telefono;
    private String direccion;
    private String vehiculoAsociado; 

    // Constructor con parámetros
    public Proveedor (String idProveedor, String nombre, String tipoServicio, 
                      String telefono, String direccion, String vehiculoAsociado){
        this.idProveedor= idProveedor;
        this.nombre=nombre;
        this.tipoServicio=tipoServicio;
        this.telefono=telefono;
        this.direccion=direccion;
        this.vehiculoAsociado=vehiculoAsociado;
    }
    
    // Constructor vacio (Ya lo tenía, bien!)
    public Proveedor()
    {
    }
    
    // --- Getters y Setters ---

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getIdProveedor() { return idProveedor; }
    public void setIdproveedor(String idProveedor) { this.idProveedor=idProveedor; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre=nombre; }
    
    public String getTipoServicio() { return tipoServicio; }
    public void setTipoServicio(String tipoServicio) { this.tipoServicio=tipoServicio; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono=telefono; }
    
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion=direccion; }
    
    public String getVehiculoAsociado() { return vehiculoAsociado; }
    public void setVehiculoAsociado(String vehiculoAsociado) { this.vehiculoAsociado=vehiculoAsociado; }
    
}
