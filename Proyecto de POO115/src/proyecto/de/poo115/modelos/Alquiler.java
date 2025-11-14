package proyecto.de.poo115.modelos;

import java.util.Date;

public class Alquiler {
    
    // 1. Campo para MongoDB
    private String id; 
    
    private String idContrato;
    private String idCliente;
    private String idVehiculo;
    private String idEmpleado;
    private String fechaInicio;
    private String fechaFin;
    private double totalPagar;

    // 2. Constructor Vacío (NECESARIO para listar del DAO)
    public Alquiler() {
    }

    // Constructor con parámetros
    public Alquiler(String idContrato, String idCliente, String idVehiculo, String idEmpleado,
                    String fechaInicio, String fechaFin, double totalPagar) {
        this.idContrato = idContrato;
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.idEmpleado = idEmpleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalPagar = totalPagar;
    }

    // --- Getters y Setters ---
    
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getIdContrato() { return idContrato; }
    public void setIdContrato(String idContrato) { this.idContrato = idContrato; }

    public String getIdCliente() { return idCliente; }
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }

    public String getIdVehiculo() { return idVehiculo; }
    public void setIdVehiculo(String idVehiculo) { this.idVehiculo = idVehiculo; }

    public String getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(String idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }

    public double getTotalPagar() { return totalPagar; }
    public void setTotalPagar(double totalPagar) { this.totalPagar = totalPagar; }

    public void setFechaInicio(Date fechaInicio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setActivo(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFechaFin(Date fechaFin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean isActivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}