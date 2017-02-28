/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imoz.daos;

import com.imoz.entidades.Articulo;
import com.imoz.entidades.Cliente;
import com.imoz.entidades.DetalleIngreso;
import com.imoz.entidades.Presentacion;
import com.imoz.entidades.Venta;
import com.imoz.servicios.EntidadService;
import com.imoz.util.Constantes;

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
    
    public EntidadService<Articulo> getArticuloDao(){
        return new ArticuloPSTDAO();
    }
    
    public EntidadService<Cliente> getClienteDao(){
        return new ClientePSTDAO();
    }
    
    public EntidadService<DetalleIngreso> getDetalleIngresoDao(){
        return new DetalleIngresoPSTDAO();
    }
    
    public EntidadService<Venta> getVentaDao(){
        return new VentaPSTDAO();
    }
}
