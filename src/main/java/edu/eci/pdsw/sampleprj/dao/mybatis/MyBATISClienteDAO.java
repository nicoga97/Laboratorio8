/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.sql.Date;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 2129175
 */
public class MyBATISClienteDAO implements ClienteDAO {

    @Inject
    private ClienteMapper clienteMapper;

    @Inject
    private ItemMapper itemMapper;

    @Override
    public void save(Cliente c) throws PersistenceException {
        clienteMapper.agregarCliente(c);
    }

    @Override
    public Cliente load(int id) throws PersistenceException {
        return clienteMapper.consultarCliente(id);
    }

    @Override
    public List<ItemRentado> consultarItems(int idCliente) throws PersistenceException {
        return clienteMapper.consultarItems(idCliente);
    }

    @Override
    public List<Cliente> consultarClientes() throws PersistenceException {
        return clienteMapper.consultarClientes();
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws PersistenceException {
        clienteMapper.vetarCliente(docu, estado);
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws PersistenceException{
        //Instant i=date.toInstant();
        //i.plusSeconds(numdias*86400);
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.DATE, numdias);
        
        //Date d=(java.sql.Date)date.(numdias);
        clienteMapper.registrarAlquilerCliente( (int)docu+item.getId(),date,docu,item.getId(),cal.getTime());
    }
}
