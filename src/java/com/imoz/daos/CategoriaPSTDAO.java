/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.Categoria;
import com.imoz.servicios.EntidadService;
import com.imoz.util.DBConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Irving
 */
public class CategoriaPSTDAO implements EntidadService<Categoria>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(Categoria t) {
        int fila=0;
        try {
            String sql = "insert into categoria values(?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2, t.getDescripcion());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return fila;
    }

    @Override
    public int eliminarEntidad(int codigo) {
        int fila=0;
        try {
            String sql = "delete from categoria where idCategoria=?";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return fila;
    }

    @Override
    public int actualizarEntidad(Categoria t) {
        int fila=0;
        try {
            String sql = "update categoria set nombre=?, descripcion=? where idCategoria=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2,t.getDescripcion());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<Categoria> obtenerEntidades() {
        List<Categoria> lista=null;
        Categoria categoria;
        try {
            String sql = "select * from categoria";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDescripcion(rst.getString(3));
                lista.add(categoria);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Categoria buscarEntidad(int codigo) {
        Categoria categoria=null;
        try {
            String sql = "select * from categoria where idCategoria=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                categoria = new Categoria();
                categoria.setIdCategoria(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDescripcion(rst.getString(3));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return categoria;
    }
    
}
