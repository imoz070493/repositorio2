/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.Venta;
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
public class VentaPSTDAO implements EntidadService<Venta>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(Venta t) {
        int fila=0;
        try {
            String sql = "insert into venta values(?,?,?,?,?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, t.getIdCliente());
            pst.setInt(2, t.getIdTrabajador());
            pst.setDate(3,t.getFecha());
            pst.setString(4,t.getTipoComprobante());
            pst.setString(5,t.getSerie());
            pst.setString(6,t.getCorrelativo());
            pst.setDouble(7,t.getIgv());
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
            String sql = "delete from venta where idventa=?";
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
    public int actualizarEntidad(Venta t) {
        int fila=0;
        try {
            String sql = "update venta set idcliente=?, idtrabajador=?, fecha=?,"
                    + "tipo_comprobante=?, serie=?, correlativo=?, igv=?"
                    + "where idventa=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, t.getIdCliente());
            pst.setInt(2, t.getIdTrabajador());
            pst.setDate(3,t.getFecha());
            pst.setString(4,t.getTipoComprobante());
            pst.setString(5,t.getSerie());
            pst.setString(6,t.getCorrelativo());
            pst.setDouble(7,t.getIgv());
            pst.setInt(8,t.getIdVenta());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<Venta> obtenerEntidades() {
        List<Venta> lista=null;
        Venta venta=null;
        try {
            String sql = "select * from venta";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                venta = new Venta();
                venta.setIdVenta(rst.getInt(1));
                venta.setIdCliente(rst.getInt(2));
                venta.setIdTrabajador(rst.getInt(3));
                venta.setFecha(rst.getDate(4));
                venta.setTipoComprobante(rst.getString(5));
                venta.setSerie(rst.getString(6));
                venta.setCorrelativo(rst.getString(7));
                venta.setIgv(rst.getDouble(8));
                lista.add(venta);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Venta buscarEntidad(int codigo) {
        Venta venta=null;
        try {
            String sql = "select * from venta where idventa=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                venta = new Venta();
                venta.setIdVenta(rst.getInt(1));
                venta.setIdCliente(rst.getInt(2));
                venta.setIdTrabajador(rst.getInt(3));
                venta.setFecha(rst.getDate(4));
                venta.setTipoComprobante(rst.getString(5));
                venta.setSerie(rst.getString(6));
                venta.setCorrelativo(rst.getString(7));
                venta.setIgv(rst.getDouble(8));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return venta;
    }
    
}
