
package cjava.pruebas;

import cjava.daos.DaoFactory;
import cjava.entidades.Presentacion;
import cjava.servicios.EntidadService;

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
            System.out.println(p);            
        }
        
    }
    
}
