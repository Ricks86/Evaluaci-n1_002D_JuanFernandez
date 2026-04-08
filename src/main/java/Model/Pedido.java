package Model;

import java.time.LocalDate;

public class Pedido {
    private int contador = 0;
    private int id;
    private String nombreCliente;
    private String desripcion;
    private Estado estado;
    private TipoPedido tipoPedido;
    private double montoTotal;
    private LocalDate fechaPedido;

    public Pedido() {
    }

    public Pedido(String nombreCliente, String desripcion, Estado estado, TipoPedido tipoPedido, double montoTotal) {
        this.id = contador++;
        this.nombreCliente = nombreCliente;
        this.desripcion = desripcion;
        this.estado = estado;
        this.tipoPedido = tipoPedido;
        this.montoTotal = montoTotal;
        this.fechaPedido = LocalDate.now();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }
}
