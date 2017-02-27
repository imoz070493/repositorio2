/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.pruebas;

import com.imoz.daos.DaoFactory;
import com.imoz.entidades.Presentacion;
import com.imoz.servicios.EntidadService;

/**
 *
 * @author Irving
 */
public class Prueba1 {
    
    public static void main(String[] args){
        //INSERTAR
        Presentacion p = new Presentacion();
        p.setNombre("Etiqueta");
        p.setDescripcion("ETIQUETA MODIFICADA");
        
        //ELIMINAR
        int id =5;
        
        //MODIFICAR
        Presentacion pm = new Presentacion();
        pm.setId(6);
        pm.setNombre("Etiqueta");
        pm.setDescripcion("ETIQUETA MODIFICADA");
        DaoFactory fabrica = DaoFactory.getInstance();
        EntidadService<Presentacion> dao = fabrica.getPresentacionDao();
        //dao.actualizarEntidad(pm);
        
        
        
    }
    
}
