/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.Cliente;
import com.imoz.servicios.EntidadService;
import com.imoz.util.DBConn;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Irving
 */
public class ClientePSTDAO implements EntidadService<Cliente>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(Cliente t) {
        int fila=0;
        try {
            String sql = "insert into cliente values(?,?,?,?,?,?,?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2, t.getApellidos());
            pst.setString(3, t.getSexo());
            pst.setDate(4, (Date) t.getFechaNacimiento());
            pst.setString(5, t.getTipoDocumento());
            pst.setString(6, t.getNumDocumento());
            pst.setString(7, t.getDireccion());
            pst.setString(8, t.getTelefono());
            pst.setString(9, t.getEmail());
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
            String sql = "delete from cliente where idCliente=?";
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
    public int actualizarEntidad(Cliente t) {
        int fila=0;
        try {
            String sql = "update cliente set nombre=?, apellidos=?, sexo=?,"
                    + "fecha_nacimiento=?, tipo_documento=?, num_documento=?,"
                    + "direccion=?, telefono=?, email=? where idCliente=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2, t.getApellidos());
            pst.setString(3, t.getSexo());
            pst.setDate(4, (Date) t.getFechaNacimiento());
            pst.setString(5, t.getTipoDocumento());
            pst.setString(6, t.getNumDocumento());
            pst.setString(7, t.getDireccion());
            pst.setString(8, t.getTelefono());
            pst.setString(9, t.getEmail());
            pst.setInt(10, t.getIdCliente());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<Cliente> obtenerEntidades() {
        List<Cliente> lista=null;
        Cliente cliente;
        try {
            String sql = "select * from cliente";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rst.getInt(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellidos(rst.getString(3));
                cliente.setSexo(rst.getString(4));
                cliente.setFechaNacimiento(rst.getDate(5));
                cliente.setTipoDocumento(rst.getString(6));
                cliente.setNumDocumento(rst.getString(7));
                cliente.setDireccion(rst.getString(8));
                cliente.setTelefono(rst.getString(9));
                cliente.setEmail(rst.getString(10));
                lista.add(cliente);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Cliente buscarEntidad(int codigo) {
        Cliente cliente=null;
        try {
            String sql = "select * from cliente where idCliente=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rst.getInt(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellidos(rst.getString(3));
                cliente.setSexo(rst.getString(4));
                cliente.setFechaNacimiento(rst.getDate(5));
                cliente.setTipoDocumento(rst.getString(6));
                cliente.setNumDocumento(rst.getString(7));
                cliente.setDireccion(rst.getString(8));
                cliente.setTelefono(rst.getString(9));
                cliente.setEmail(rst.getString(10));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return cliente;
    }
    
}
