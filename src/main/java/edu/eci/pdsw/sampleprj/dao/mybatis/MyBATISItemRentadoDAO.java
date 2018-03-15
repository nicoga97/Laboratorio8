/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.sql.Date;

/**
 *
 * @author nicoga
 */
public class MyBATISItemRentadoDAO implements ItemRentadoDAO{
    
    @Inject
    private ItemRentadoMapper itemRentadoMapper;    
    
    @Override
    public ItemRentado load(int id) throws PersistenceException {
        return itemRentadoMapper.consultarItemRentado(id);}

    

   
    
}
