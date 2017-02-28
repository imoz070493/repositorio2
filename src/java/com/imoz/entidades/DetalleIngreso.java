package com.imoz.entidades;

import java.sql.Date;

public class DetalleIngreso {

    int idDetalleIngreso;
    int idIngreso;
    int idArticulo;
    double precioCompra;
    double precioVenta;
    int stockInicial;
    int stockActual;
    Date fechaProduccion;
    Date fechaVencimiento;

    public DetalleIngreso() {
    }

    public DetalleIngreso(int idIngreso, int idArticulo, double precioCompra, double precioVenta, int stockInicial, int stockActual, Date fechaProduccion, Date fechaVencimiento) {
        this.idIngreso = idIngreso;
        this.idArticulo = idArticulo;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stockInicial = stockInicial;
        this.stockActual = stockActual;
        this.fechaProduccion = fechaProduccion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getIdDetalleIngreso() {
        return idDetalleIngreso;
    }

    public void setIdDetalleIngreso(int idDetalleIngreso) {
        this.idDetalleIngreso = idDetalleIngreso;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(int stockInicial) {
        this.stockInicial = stockInicial;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "DetalleIngreso{" + "idDetalleIngreso=" + idDetalleIngreso + ", idIngreso=" + idIngreso + ", idArticulo=" + idArticulo + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", stockInicial=" + stockInicial + ", stockActual=" + stockActual + ", fechaProduccion=" + fechaProduccion + ", fechaVencimiento=" + fechaVencimiento + '}';
    }
    
    
    
}
