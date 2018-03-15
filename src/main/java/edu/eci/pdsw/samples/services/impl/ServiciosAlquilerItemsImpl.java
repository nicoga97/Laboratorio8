package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
@Singleton
public class ServiciosAlquilerItemsImpl implements ServiciosAlquiler {

    @Inject
    private ItemDAO daoItem;

    @Inject
    private ClienteDAO daoCliente;

    @Inject
    private ItemRentadoDAO daoItemRentado;

    @Inject
    private TipoItemDAO tipoItemDAO;

    @Override
    public int valorMultaRetrasoxDia(int itemId) {
        return 5000;
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        try {
            return daoCliente.load((int) docu);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el cliente " + docu, ex);
        }
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        try {
            return daoCliente.consultarItems((int) idcliente);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar items del cliente " + idcliente, ex);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try {
            return daoCliente.consultarClientes();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar  clientes ", ex);
        }

    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return daoItem.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item " + id, ex);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() throws ExcepcionServiciosAlquiler {
        try {
            return daoItem.consultarItemsDisponibles();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item ");
        }
    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        try {
            return daoItemRentado.consultarMultaAlquiler(iditem, fechaDevolucion)*valorMultaRetrasoxDia(iditem);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar multa ");
        }
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return tipoItemDAO.load(id);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el tipo item ");
        }
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        try {
            return tipoItemDAO.consultarTiposItems();
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar los tipo items ");
        }
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
        try {
			daoCliente.registrarAlquilerCliente(date, docu, item, numdias);
		} catch (PersistenceException e) {
			throw new ExcepcionServiciosAlquiler("Error al agregar el item rentado al cliente ");
		}
    }

    @Override
    public void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler {
        try {
            daoCliente.save(p);
        } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al insertar el cliente");
        }
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        try {
            return (long) daoItem.consultarCostoAlquiler(iditem, numdias);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el costo de alquiler");
        }
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        try {
            daoItem.actualizarTarifaItem(id, tarifa);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al actualizar");
        }
    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        try {
            daoItem.save(i);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al insertar item");
        }
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        try {
            daoCliente.vetarCliente(docu, estado);
        } catch (PersistenceException e) {
            throw new ExcepcionServiciosAlquiler("Error al vetar el cliente");
        }
    }

}
