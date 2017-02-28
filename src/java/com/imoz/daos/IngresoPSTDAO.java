/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.Ingreso;
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
public class IngresoPSTDAO implements EntidadService<Ingreso>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(Ingreso t) {
        int fila=0;
        try {
            String sql = "insert into ingreso values(?,?,?,?,?,?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, t.getIdTrabajador());
            pst.setInt(2, t.getIdProveedor());
            pst.setDate(3,t.getFecha());
            pst.setString(4,t.getTipoComprobante());
            pst.setString(5,t.getSerie());
            pst.setString(6,t.getCorrelativo());
            pst.setDouble(7,t.getIgv());
            pst.setString(8,t.getEstado());
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
            String sql = "delete from ingreso where idingreso=?";
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
    public int actualizarEntidad(Ingreso t) {
        int fila=0;
        try {
            String sql = "update ingreso set idtrabajador=?, idproveedor=?,"
                    + "fecha=?, tipo_comprobante=?, serie=?, correlativo=?"
                    + "igv=?, estado=? where idingreso=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, t.getIdTrabajador());
            pst.setInt(2, t.getIdProveedor());
            pst.setDate(3,t.getFecha());
            pst.setString(4,t.getTipoComprobante());
            pst.setString(5,t.getSerie());
            pst.setString(6,t.getCorrelativo());
            pst.setDouble(7,t.getIgv());
            pst.setString(8,t.getEstado());
            pst.setInt(9,t.getIdIngreso());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<Ingreso> obtenerEntidades() {
        List<Ingreso> lista=null;
        Ingreso ingreso=null;
        try {
            String sql = "select * from ingreso";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                ingreso = new Ingreso();
                ingreso.setIdIngreso(rst.getInt(1));
                ingreso.setIdTrabajador(rst.getInt(2));
                ingreso.setIdProveedor(rst.getInt(3));
                ingreso.setFecha(rst.getDate(4));
                ingreso.setTipoComprobante(rst.getString(5));
                ingreso.setSerie(rst.getString(6));
                ingreso.setCorrelativo(rst.getString(7));
                ingreso.setIgv(rst.getInt(8));
                ingreso.setEstado(rst.getString(9));
                lista.add(ingreso);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Ingreso buscarEntidad(int codigo) {
        Ingreso ingreso=null;
        try {
            String sql = "select * from ingreso where idingreso=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                ingreso = new Ingreso();
                ingreso.setIdIngreso(rst.getInt(1));
                ingreso.setIdTrabajador(rst.getInt(2));
                ingreso.setIdProveedor(rst.getInt(3));
                ingreso.setFecha(rst.getDate(4));
                ingreso.setTipoComprobante(rst.getString(5));
                ingreso.setSerie(rst.getString(6));
                ingreso.setCorrelativo(rst.getString(7));
                ingreso.setIgv(rst.getInt(8));
                ingreso.setEstado(rst.getString(9));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return ingreso;
    }
    
}
