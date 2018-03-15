/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Item;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public interface ItemDAO {

    public void save(Item it) throws PersistenceException;
    
    public Item load(int id) throws PersistenceException;
    public  List<Item> consultarItemsDisponibles() throws PersistenceException;
    /*default public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws PersistenceException{
        Item i= load(iditem);
        
    }*/
    public long consultarCostoAlquiler(int iditem, int numdias) throws PersistenceException;
    public void actualizarTarifaItem(int id, long tarifa) throws PersistenceException;
    
}
