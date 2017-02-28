package com.imoz.pruebas;

import com.imoz.daos.DaoFactory;
import com.imoz.entidades.DetalleIngreso;
import com.imoz.servicios.EntidadService;

public class DetalleIngresoPrueba1 {

    public static void main(String[] args) {

        DaoFactory fabrica = DaoFactory.getInstance();
        EntidadService<DetalleIngreso> dao = fabrica.getDetalleIngresoDao();
        
        //Obtener
        for(DetalleIngreso d: dao.obtenerEntidades()){
            System.out.println(d);
        }
        
    }
    
}
