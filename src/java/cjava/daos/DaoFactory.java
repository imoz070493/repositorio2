/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjava.daos;

import cjava.entidades.Presentacion;
import cjava.servicios.EntidadService;
import cjava.util.Constantes;

/**
 *
 * @author emaravi
 */
public class DaoFactory {
    
    private DaoFactory() {
    }
    
    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }
    
    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }
    
    public EntidadService<Presentacion> getPresentacionDao(){
        return new PresentacionPSTDAO();
    }
}
