/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.DetalleIngreso;
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
public class DetalleIngresoPSTDAO implements EntidadService<DetalleIngreso>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(DetalleIngreso t) {
        int fila=0;
        try {
            String sql = "insert into detalle_ingreso values(?,?,?,?,?,?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, t.getIdIngreso());
            pst.setInt(2, t.getIdArticulo());
            pst.setDouble(3,t.getPrecioCompra());
            pst.setDouble(4,t.getPrecioVenta());
            pst.setInt(5,t.getStockInicial());
            pst.setInt(6,t.getStockActual());
            pst.setDate(7,t.getFechaProduccion());
            pst.setDate(8,t.getFechaVencimiento());
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
            String sql = "delete from detalle_ingreso where iddetalle_ingreso=?";
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
    public int actualizarEntidad(DetalleIngreso t) {
        int fila=0;
        try {
            String sql = "update detalle_ingreso set idingreso=?, iddetalleIngreso=?,"
                    + "precio_compra=?,precio_venta=?, stock_inicial=?,"
                    + "fecha_produccion=?, fecha_vencimiento=? where iddetalle_ingreso=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, t.getIdIngreso());
            pst.setInt(2, t.getIdArticulo());
            pst.setDouble(3,t.getPrecioCompra());
            pst.setDouble(4,t.getPrecioVenta());
            pst.setInt(5,t.getStockInicial());
            pst.setInt(6,t.getStockActual());
            pst.setDate(7,t.getFechaProduccion());
            pst.setDate(8,t.getFechaVencimiento());
            pst.setInt(9,t.getIdDetalleIngreso());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<DetalleIngreso> obtenerEntidades() {
        List<DetalleIngreso> lista=null;
        DetalleIngreso detalleIngreso=null;
        try {
            String sql = "select * from detalle_ingreso";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                detalleIngreso = new DetalleIngreso();
                detalleIngreso.setIdDetalleIngreso(rst.getInt(1));
                detalleIngreso.setIdIngreso(rst.getInt(2));
                detalleIngreso.setIdArticulo(rst.getInt(3));
                detalleIngreso.setPrecioCompra(rst.getDouble(4));
                detalleIngreso.setPrecioVenta(rst.getDouble(5));
                detalleIngreso.setStockInicial(rst.getInt(6));
                detalleIngreso.setStockActual(rst.getInt(7));
                detalleIngreso.setFechaProduccion(rst.getDate(8));
                detalleIngreso.setFechaVencimiento(rst.getDate(9));
                lista.add(detalleIngreso);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public DetalleIngreso buscarEntidad(int codigo) {
        DetalleIngreso detalleIngreso=null;
        try {
            String sql = "select * from detalleIngreso where iddetalleIngreso=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                detalleIngreso = new DetalleIngreso();
                detalleIngreso.setIdDetalleIngreso(rst.getInt(1));
                detalleIngreso.setIdIngreso(rst.getInt(2));
                detalleIngreso.setIdArticulo(rst.getInt(3));
                detalleIngreso.setPrecioCompra(rst.getDouble(4));
                detalleIngreso.setPrecioVenta(rst.getDouble(5));
                detalleIngreso.setStockInicial(rst.getInt(6));
                detalleIngreso.setStockActual(rst.getInt(7));
                detalleIngreso.setFechaProduccion(rst.getDate(8));
                detalleIngreso.setFechaVencimiento(rst.getDate(9));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return detalleIngreso;
    }
    
}
