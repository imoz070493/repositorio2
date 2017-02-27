/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.entidades;

import java.sql.Blob;

/**
 *
 * @author Irving
 */
public class Articulo {
    
    private int idArticulo;
    private String codigo;
    private String nombre;
    private String descripcion;
    private byte [] image;
    private int idCategoria;
    private int idPresentacion;

    public Articulo() {
    }

    public Articulo(int idArticulo, String codigo, String nombre, String descripcion, byte[] image, int idCategoria) {
        this.idArticulo = idArticulo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.image = image;
        this.idCategoria = idCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getImage(){
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    @Override
    public String toString() {
        
        return "Articulo{" + "idArticulo=" + idArticulo + ", codigo=" + 
                codigo + ", nombre=" + nombre + ", descripcion=" + descripcion
                + ", image=" + image + ", idCategoria=" + idCategoria + ", "
                + "idPresentacion=" + idPresentacion + '}';
    }
    
    
    
}
