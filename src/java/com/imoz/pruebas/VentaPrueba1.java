package com.imoz.pruebas;

import com.imoz.daos.DaoFactory;
import com.imoz.entidades.Venta;
import com.imoz.servicios.EntidadService;

public class VentaPrueba1 {
    
    public static void main(String... args){
        DaoFactory fabrica = DaoFactory.getInstance();
        EntidadService<Venta> dao = fabrica.getVentaDao();

        for(Venta v: dao.obtenerEntidades()){
            System.out.println(v);
        }
    }

    
}
