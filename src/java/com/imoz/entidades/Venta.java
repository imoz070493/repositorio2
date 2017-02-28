package com.imoz.entidades;

import java.sql.Date;

public class Venta {
    
    private int idVenta;
    private int idCliente;
    private int idTrabajador;
    private Date fecha;
    private String tipoComprobante;
    private String serie;
    private String correlativo;
    private double igv;

    public Venta() {
    }

    public Venta(int idCliente, int idTrabajador, Date fecha, String tipoComprobante, String serie, String correlativo, double igv) {
        this.idCliente = idCliente;
        this.idTrabajador = idTrabajador;
        this.fecha = fecha;
        this.tipoComprobante = tipoComprobante;
        this.serie = serie;
        this.correlativo = correlativo;
        this.igv = igv;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idCliente=" + idCliente + ", idTrabajador=" + idTrabajador + ", fecha=" + fecha + ", tipoComprobante=" + tipoComprobante + ", serie=" + serie + ", correlativo=" + correlativo + ", igv=" + igv + '}';
    }
    
}
