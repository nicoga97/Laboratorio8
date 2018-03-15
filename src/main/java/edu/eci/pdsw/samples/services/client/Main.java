/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services.client;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String a[]) throws ExcepcionServiciosAlquiler {
        ServiciosAlquiler b=ServiciosAlquilerFactory.getInstance().getServiciosAlquiler();
               
        
        System.out.println(b.consultarItem(2)+"\n");
        System.out.println(b.consultarCliente(21048352)+"\n");
        System.out.println(b.consultarItemsCliente(21048352)+"\n");
        System.out.println(b.consultarClientes()+"\n");
        System.out.println(b.consultarItemsDisponibles()+"\n");
        System.out.println(b.consultarTipoItem(0)+"\n");
        System.out.println(b.consultarTiposItem()+"\n");
        System.out.println(b.consultarCostoAlquiler(1, 10)+"\n");
        b.actualizarTarifaItem(1, 1000);
        b.vetarCliente(21048352, false);;
        System.out.println(b.consultarMultaAlquiler(1, Date.valueOf("2017-05-02"))+"\n");
        b.registrarAlquilerCliente(java.sql.Date.valueOf("2017-05-02"), 1684264984, b.consultarItem(55), 5);
        b.registrarItem(new Item(new TipoItem(3,"Musica"), 456, "Thriller", "p1111.", java.sql.Date.valueOf("1984-01-11"), 2000, "DVD", "Pop"));
        b.registrarCliente(new Cliente("Niquito", 786874453, "5657557", "KRA 109#34-C30", "Niquito@hotmail.com", false,new ArrayList<ItemRentado>()));
        System.exit(0);
    }

}
