/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.Trabajador;
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
public class TrabajadorPSTDAO implements EntidadService<Trabajador>{

    Connection con;
    PreparedStatement pst;
    ResultSet rst;
    
    @Override
    public int crearEntidad(Trabajador t) {
        int fila=0;
        try {
            String sql = "insert into trabajador values(?,?,?,?,?,?,?,?,?,?,?)";
            con = DBConn.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2, t.getApellidos());
            pst.setString(3,t.getSexo());
            pst.setDate(4,t.getFechaNacimiento());
            pst.setString(5,t.getNumDocumento());
            pst.setString(6,t.getDireccion());
            pst.setString(7,t.getTelefono());
            pst.setString(8,t.getEmail());
            pst.setString(9,t.getAcceso());
            pst.setString(10,t.getUsuario());
            pst.setString(11,t.getPassword());
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
            String sql = "delete from trabajador where idtrabajador=?";
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
    public int actualizarEntidad(Trabajador t) {
        int fila=0;
        try {
            String sql = "update trabajador set nombre=?, apellidos=?, sexo=?,"
                    + "fecha_nac=?, num_documento=?, direccion=?, "
                    + "telefono=?, email=?, acceso=?, usuario=?, password=?,"
                    + "where idtrabajador=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setString(1, t.getNombre());
            pst.setString(2, t.getApellidos());
            pst.setString(3,t.getSexo());
            pst.setDate(4,t.getFechaNacimiento());
            pst.setString(5,t.getNumDocumento());
            pst.setString(6,t.getDireccion());
            pst.setString(7,t.getTelefono());
            pst.setString(8,t.getEmail());
            pst.setString(9,t.getAcceso());
            pst.setString(10,t.getUsuario());
            pst.setString(11,t.getPassword());
            pst.setInt(12,t.getIdTrabajador());
            fila = pst.executeUpdate();
            con.close();
        }catch(SQLException ex){
            System.out.println("Error actualziar"+ex);
        }
        return fila;
    }

    @Override
    public List<Trabajador> obtenerEntidades() {
        List<Trabajador> lista=null;
        Trabajador trabajador=null;
        try {
            String sql = "select * from trabajador";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            rst = pst.executeQuery();
            lista = new ArrayList<>();
            while(rst.next()){
                trabajador = new Trabajador();
                trabajador.setIdTrabajador(rst.getInt(1));
                trabajador.setNombre(rst.getString(2));
                trabajador.setApellidos(rst.getString(3));
                trabajador.setSexo(rst.getString(4));
                trabajador.setFechaNacimiento(rst.getDate(5));
                trabajador.setNumDocumento(rst.getString(6));
                trabajador.setDireccion(rst.getString(7));
                trabajador.setTelefono(rst.getString(8));
                trabajador.setEmail(rst.getString(9));
                trabajador.setAcceso(rst.getString(10));
                trabajador.setUsuario(rst.getString(11));
                lista.add(trabajador);
            }
            con.close();
        }catch(SQLException ex){
            System.out.println("Error:"+ex.getMessage());
        }
        return lista;
    }

    @Override
    public Trabajador buscarEntidad(int codigo) {
        Trabajador trabajador=null;
        try {
            String sql = "select * from trabajador where idtrabajador=?";
            con = DBConn.getConnection();
            pst = con.prepareCall(sql);
            pst.setInt(1, codigo);
            rst = pst.executeQuery();
            if(rst.next()){
                trabajador = new Trabajador();
                trabajador.setIdTrabajador(rst.getInt(1));
                trabajador.setNombre(rst.getString(2));
                trabajador.setApellidos(rst.getString(3));
                trabajador.setSexo(rst.getString(4));
                trabajador.setFechaNacimiento(rst.getDate(5));
                trabajador.setNumDocumento(rst.getString(6));
                trabajador.setDireccion(rst.getString(7));
                trabajador.setTelefono(rst.getString(8));
                trabajador.setEmail(rst.getString(9));
                trabajador.setAcceso(rst.getString(10));
                trabajador.setUsuario(rst.getString(11));
            }
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return trabajador;
    }
    
}
