/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.entidades;

/**
 *
 * @author Irving
 */
public class Categoria {
    
    private int idCategoria;
    private String nombre;
    private String descripcion;

    public Categoria() {
        
    }

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    
    
    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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
    
    
    
}
