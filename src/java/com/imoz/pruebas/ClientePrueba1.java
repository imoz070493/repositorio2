package com.imoz.pruebas;

import com.imoz.daos.DaoFactory;
import com.imoz.entidades.Cliente;
import com.imoz.servicios.EntidadService;
import java.sql.Date;


public class ClientePrueba1 {

    public static void main(String... args){
        DaoFactory fabrica = DaoFactory.getInstance();
        EntidadService<Cliente> dao = fabrica.getClienteDao();
        ////////////////////////////////
        //Insertar
//        Cliente c = new Cliente();
//        c.setNombre("Irving");
//        c.setApellidos("Ortega");
//        c.setSexo("M");
//        Date d = new Date(93, 04, 07);
//        c.setFechaNacimiento(d);
//        c.setTipoDocumento("DNI");
//        c.setNumDocumento("72914438");
//        c.setDireccion("Av. ...");
//        c.setTelefono("9876543221");
//        c.setEmail("irving@gmail.com");
//        dao.crearEntidad(c);

        //OBTENER Clientes
        for(Cliente c: dao.obtenerEntidades()){
            System.out.println(c);
        }
    }
    
}
