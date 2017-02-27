/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.pruebas;

import com.imoz.daos.DaoFactory;
import com.imoz.entidades.Articulo;
import com.imoz.servicios.EntidadService;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Irving
 */
public class ArticuloPrueba1 {
    
    public static void main(String[] args) throws SQLException, IOException{
        DaoFactory fabrica = DaoFactory.getInstance();
        EntidadService<Articulo> dao =  fabrica.getArticuloDao();

        /////////////////////////////////////////////////////////
        //Obtener
//        Articulo a = dao.buscarEntidad(6);
//        
//        try{
//            FileOutputStream fos = new FileOutputStream("destino1.jpg");
//            
//                fos.write(a.getImage());
//             
//        } catch (Exception e) {
//             System.out.println ("File not found: " + e);
//        }
        /////////////////////////////////////////////////////////
        //Insertar
//        Articulo a = new Articulo();
//        File archivo = new File("destino.jpg");
//        byte[] imgFoto = new byte[(int) archivo.length()];
//        InputStream input = new FileInputStream(archivo);
//        input.read(imgFoto);
//        a.setCodigo("A1");
//        a.setNombre("Leche");
//        a.setDescripcion("Leche enlatada");
//        a.setImage(imgFoto);
//        a.setIdCategoria(7);
//        a.setIdPresentacion(4);
//        dao.crearEntidad(a);
    }
    
}
