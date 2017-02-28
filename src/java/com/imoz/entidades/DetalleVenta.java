package com.imoz.entidades;

public class DetalleVenta {
    
    private int idDetalleVenta;
    private int idVenta;
    private int idDetalleIngreso;
    private int cantidad;
    private double precioVenta;
    private double descuento;

    public DetalleVenta() {
    }

    public DetalleVenta(int idVenta, int idDetalleIngreso, int cantidad, double precioVenta, double descuento) {
        this.idVenta = idVenta;
        this.idDetalleIngreso = idDetalleIngreso;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdDetalleIngreso() {
        return idDetalleIngreso;
    }

    public void setIdDetalleIngreso(int idDetalleIngreso) {
        this.idDetalleIngreso = idDetalleIngreso;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idVenta=" + idVenta + ", idDetalleIngreso=" + idDetalleIngreso + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", descuento=" + descuento + '}';
    }
    
    
    
}
