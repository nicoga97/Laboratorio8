/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import java.sql.Date;

/**
 *
 * @author nicoga
 */
public interface ItemRentadoDAO {
    
    public ItemRentado load(int id) throws PersistenceException;
    public default long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException{
        ItemRentado i= load(iditem);
        long multa= (fechaDevolucion.getTime()-i.getFechafinrenta().getTime())/86400000;
        if(multa>0){
        return multa;
        }else{return 0;}
    };
}
