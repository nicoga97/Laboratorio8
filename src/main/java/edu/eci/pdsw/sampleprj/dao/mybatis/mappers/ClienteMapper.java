package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    
      public Cliente consultarCliente(@Param("idcli") int id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idcli")int id, 
            @Param("idit")int idit, 
            @Param("fechain")Date fechainicio,
            @Param("fechafin")Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();
    
    public void agregarCliente(@Param("cli") Cliente cliente);
    
    public List<ItemRentado> consultarItems(@Param("idcli") int idCliente);
    
    public void vetarCliente(@Param("idcli") long docu, @Param("estado") boolean estado);
    
    public void registrarAlquilerCliente(@Param("id")int i,@Param("fecha") java.sql.Date date, @Param("idcli")long docu, @Param("iditem")int iditem, @Param("fechafin") Date numdias) ;
    
}
