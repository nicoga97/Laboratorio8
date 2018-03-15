package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Item;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ItemMapper {
    
    
    
    public List<Item> consultarItems();
    
    public Item consultarItem(@Param("iditem") int id);
    
    public void insertarItem(@Param("item") Item it);
    
    public List<Item> consultarItemsDisponibles();

    public long consultarMultaAlquiler(@Param("iditem") int iditem, @Param("fechaDevolucion") Date fechaDevolucion);
    
    public Item consultarCostoAlquiler(@Param("iditem") int iditem, @Param("num") int numdias);
    
    public void actualizarTarifaItem(@Param("iditem") int id, @Param("tarifa") long tarifa);
}
