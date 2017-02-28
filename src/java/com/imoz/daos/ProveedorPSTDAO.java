/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.Proveedor;
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
public class ProveedorPSTDAO implements EntidadService<Proveedor>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(Proveedor t) {
        int fila=0;
        try {
            String sql = "insert into proveedor values(?,?,?,?,?,?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getRazonSocial());
            pst.setString(2, t.getSectorComercial());
            pst.setString(3,t.getTipoDocumento());
            pst.setString(4,t.getNumDocumento());
            pst.setString(5,t.getDireccion());
            pst.setString(6,t.getTelefono());
            pst.setString(7,t.getEmail());
            pst.setString(8,t.getUrl());
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
            String sql = "delete from proveedor where idproveedor=?";
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
    public int actualizarEntidad(Proveedor t) {
        int fila=0;
        try {
            String sql = "update proveedor set razon_social=?, sector_comercial=?,"
                    + "tipo_documento=?, num_documento=?, direccion=?, "
                    + "telefono=?, email=?, url=? where idproveedor=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setString(1, t.getRazonSocial());
            pst.setString(2, t.getSectorComercial());
            pst.setString(3,t.getTipoDocumento());
            pst.setString(4,t.getNumDocumento());
            pst.setString(5,t.getDireccion());
            pst.setString(6,t.getTelefono());
            pst.setString(7,t.getEmail());
            pst.setString(8,t.getUrl());
            pst.setInt(9,t.getIdProveedor());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<Proveedor> obtenerEntidades() {
        List<Proveedor> lista=null;
        Proveedor proveedor=null;
        try {
            String sql = "select * from proveedor";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rst.getInt(1));
                proveedor.setRazonSocial(rst.getString(2));
                proveedor.setSectorComercial(rst.getString(3));
                proveedor.setTipoDocumento(rst.getString(4));
                proveedor.setNumDocumento(rst.getString(5));
                proveedor.setDireccion(rst.getString(6));
                proveedor.setTelefono(rst.getString(7));
                proveedor.setEmail(rst.getString(8));
                proveedor.setUrl(rst.getString(9));
                lista.add(proveedor);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Proveedor buscarEntidad(int codigo) {
        Proveedor proveedor=null;
        try {
            String sql = "select * from proveedor where idproveedor=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rst.getInt(1));
                proveedor.setRazonSocial(rst.getString(2));
                proveedor.setSectorComercial(rst.getString(3));
                proveedor.setTipoDocumento(rst.getString(4));
                proveedor.setNumDocumento(rst.getString(5));
                proveedor.setDireccion(rst.getString(6));
                proveedor.setTelefono(rst.getString(7));
                proveedor.setEmail(rst.getString(8));
                proveedor.setUrl(rst.getString(9));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return proveedor;
    }
    
}
