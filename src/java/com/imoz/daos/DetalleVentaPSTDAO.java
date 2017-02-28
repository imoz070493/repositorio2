/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.DetalleVenta;
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
public class DetalleVentaPSTDAO implements EntidadService<DetalleVenta>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(DetalleVenta t) {
        int fila=0;
        try {
            String sql = "insert into detalle_ingreso values(?,?,?,?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, t.getIdVenta());
            pst.setInt(2, t.getIdDetalleIngreso());
            pst.setInt(3,t.getCantidad());
            pst.setDouble(4,t.getPrecioVenta());
            pst.setDouble(5,t.getDescuento());
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
            String sql = "delete from detalle_venta where iddetalle_venta=?";
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
    public int actualizarEntidad(DetalleVenta t) {
        int fila=0;
        try {
            String sql = "update detalle_venta set iddetalle_venta=?, idventa=?,"
                    + "iddetalle_ingreso=?,cantidad=?, precio_venta=?,"
                    + "descuento=? where iddetalle_venta=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, t.getIdVenta());
            pst.setInt(2, t.getIdDetalleIngreso());
            pst.setInt(3,t.getCantidad());
            pst.setDouble(4,t.getPrecioVenta());
            pst.setDouble(5,t.getDescuento());
            pst.setInt(6,t.getIdDetalleVenta());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<DetalleVenta> obtenerEntidades() {
        List<DetalleVenta> lista=null;
        DetalleVenta detalleVenta=null;
        try {
            String sql = "select * from detalle_venta";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                detalleVenta = new DetalleVenta();
                detalleVenta.setIdDetalleVenta(rst.getInt(1));
                detalleVenta.setIdVenta(rst.getInt(2));
                detalleVenta.setIdDetalleIngreso(rst.getInt(3));
                detalleVenta.setCantidad(rst.getInt(4));
                detalleVenta.setPrecioVenta(rst.getDouble(5));
                detalleVenta.setDescuento(rst.getInt(6));
                lista.add(detalleVenta);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public DetalleVenta buscarEntidad(int codigo) {
        DetalleVenta detalleVenta=null;
        try {
            String sql = "select * from detalle_venta where iddetalle_venta=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                detalleVenta = new DetalleVenta();
                detalleVenta.setIdDetalleVenta(rst.getInt(1));
                detalleVenta.setIdVenta(rst.getInt(2));
                detalleVenta.setIdDetalleIngreso(rst.getInt(3));
                detalleVenta.setCantidad(rst.getInt(4));
                detalleVenta.setPrecioVenta(rst.getDouble(5));
                detalleVenta.setDescuento(rst.getInt(6));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return detalleVenta;
    }
    
}
