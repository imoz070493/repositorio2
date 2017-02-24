/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjava.daos;

import cjava.entidades.Presentacion;
import cjava.entidades.Presentacion;
import cjava.servicios.EntidadService;
import cjava.util.DBConn;
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
public class PresentacionPSTDAO implements EntidadService<Presentacion>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(Presentacion t) {
        int fila=0;
        try {
            String sql = "insert into presentacion values(?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2,t.getDescripcion());
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
            String sql = "delete from presentacion where idpresentacion=?";
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
    public int actualizarEntidad(Presentacion t) {
        int fila=0;
        try {
            String sql = "update presentacion set nombre=?, descripcion=? where idpresentacion=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2,t.getDescripcion());
            pst.setInt(3, t.getId());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<Presentacion> obtenerEntidades() {
        List<Presentacion> lista=null;
        Presentacion presentacion=null;
        try {
            String sql = "select * from presentacion";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                presentacion = new Presentacion();
                presentacion.setId(rst.getInt(1));
                presentacion.setNombre(rst.getString(2));
                presentacion.setDescripcion(rst.getString(3));
                lista.add(presentacion);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    @Override
    public Presentacion buscarEntidad(int codigo) {
        Presentacion presentacion=null;
        try {
            String sql = "select * from presentacion where idpresentacion=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                presentacion = new Presentacion();
                presentacion.setId(rst.getInt(1));
                presentacion.setNombre(rst.getString(2));
                presentacion.setDescripcion(rst.getString(3));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return presentacion;
    }
    
}
