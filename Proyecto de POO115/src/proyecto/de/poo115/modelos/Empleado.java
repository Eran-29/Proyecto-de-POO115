package proyecto.de.poo115.modelos;

import java.util.ArrayList;

public class Empleado {
    // 1. Campo para MongoDB
    private String id;
    
    // 2. Atributos SIN "final"
    private int codigo;
    private String nombre;
    private String apellido;
    private String cargo;
    private double salario;
    private ArrayList<String> contratos; 

    // 3. Constructor Vacío (NECESARIO para listar del DAO)
    public Empleado() {
        this.contratos = new ArrayList<>();
    }

    // Constructor con parámetros (Original)
    public Empleado(int codigo, String nombre, String apellido, String cargo, double salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.contratos = new ArrayList<>();
    }

    // --- Getters y Setters ---

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    // Ahora tienen Setters, lo cual es vital para el DAO
    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
    
    public ArrayList<String> getContratos() { return contratos; }
    public void setContratos(ArrayList<String> contratos) { this.contratos = contratos; }
    
    // Métodos de lógica (como asignarContrato) déjalos como están.
}