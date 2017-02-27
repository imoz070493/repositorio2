
package com.imoz.pruebas;

import com.imoz.daos.DaoFactory;
import com.imoz.entidades.Presentacion;
import com.imoz.servicios.EntidadService;

public class Prueba2 {
    
    public static void main(String[] args){
        DaoFactory fabrica = DaoFactory.getInstance();
        EntidadService<Presentacion> dao = fabrica.getPresentacionDao();
        //OBTENER OBJETO PRESENTACION
        int idP=6;
        Presentacion objP = new Presentacion();
        objP = dao.buscarEntidad(idP);
        System.out.println(objP);
        System.out.println("////////////////////////////");
        
        for (Presentacion p : dao.obtenerEntidades()) {
            
        }
        
    }
    
}
