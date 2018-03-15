/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.sql.Date;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author nicoga
 */
public interface ItemRentadoMapper {
    public ItemRentado consultarItemRentado(@Param("idItemRentado")int id);
    public long consultarMultaAlquiler(@Param("idItemRentado")int iditem, @Param("fechaDev")Date fechaDevolucion) ;
}
