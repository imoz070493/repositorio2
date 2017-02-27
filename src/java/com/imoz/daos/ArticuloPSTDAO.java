/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.Articulo;
import com.imoz.servicios.EntidadService;
import com.imoz.util.DBConn;
import java.sql.Blob;
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
public class ArticuloPSTDAO implements EntidadService<Articulo>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(Articulo t) {
        int fila=0;
        try {
            String sql = "insert into articulo values(?,?,?,?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getCodigo());
            pst.setString(2, t.getNombre());
            pst.setString(3,t.getDescripcion());
            pst.setBytes(4,t.getImage());
            pst.setInt(5,t.getIdCategoria());
            pst.setInt(6,t.getIdPresentacion());
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
            String sql = "delete from articulo where idarticulo=?";
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
    public int actualizarEntidad(Articulo t) {
        int fila=0;
        try {
            String sql = "update articulo set nombre=?, descripcion=? where idarticulo=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2,t.getDescripcion());
            pst.setInt(3, t.getIdArticulo());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<Articulo> obtenerEntidades() {
        List<Articulo> lista=null;
        Articulo articulo=null;
        try {
            String sql = "select * from articulo";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                articulo = new Articulo();
                articulo.setIdArticulo(rst.getInt(1));
                articulo.setCodigo(rst.getString(2));
                articulo.setNombre(rst.getString(3));
                articulo.setDescripcion(rst.getString(4));
                articulo.setImage(rst.getBytes(5));
                articulo.setIdCategoria(rst.getInt(6));
                articulo.setIdPresentacion(rst.getInt(7));
                lista.add(articulo);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Articulo buscarEntidad(int codigo) {
        Articulo articulo=null;
        try {
            String sql = "select * from articulo where idarticulo=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                articulo = new Articulo();
                articulo.setIdArticulo(rst.getInt(1));
                articulo.setCodigo(rst.getString(2));
                articulo.setNombre(rst.getString(3));
                articulo.setDescripcion(rst.getString(4));
                articulo.setImage(rst.getBytes(5));
                articulo.setIdCategoria(rst.getInt(6));
                articulo.setIdPresentacion(rst.getInt(7));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return articulo;
    }
    
}
