package com.evaluacion.QuickOrder.Model;



import java.time.LocalDate;

public class Pedido {
    //atributos de nuestro modelo
    private int id;
    private String nombreCliente;
    private String descripcion;
    private Estado estado;
    private TipoPedido tipoPedido;
    private double montoTotal;
    private LocalDate fechaPedido;

    //constructor
    public Pedido(String nombreCliente, String descripcion, Estado estado, TipoPedido tipoPedido, double montoTotal) {
        this.nombreCliente = nombreCliente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipoPedido = tipoPedido;
        this.montoTotal = montoTotal;
        this.fechaPedido = LocalDate.now();
    }
    //constructor vacio
    public Pedido(){}
    //getters y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
