package com.imoz.entidades;

import java.sql.Date;

public class Ingreso {
    
    private int idIngreso;
    private int idTrabajador;
    private int idProveedor;
    private Date fecha;
    private String tipoComprobante;
    private String serie;
    private String correlativo;
    private double igv;
    private String estado;

    public Ingreso() {
    }

    public Ingreso(int idTrabajador, int idProveedor, Date fecha, String tipoComprobante, String serie, String correlativo, double igv, String estado) {
        this.idTrabajador = idTrabajador;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
        this.tipoComprobante = tipoComprobante;
        this.serie = serie;
        this.correlativo = correlativo;
        this.igv = igv;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    @Override
    public String toString() {
        return "Ingreso{" + "idIngreso=" + idIngreso + ", idTrabajador=" + idTrabajador + ", idProveedor=" + idProveedor + ", fecha=" + fecha + ", tipoComprobante=" + tipoComprobante + ", serie=" + serie + ", correlativo=" + correlativo + ", igv=" + igv + ", estado=" + estado + '}';
    }
    
    
    
    
}
