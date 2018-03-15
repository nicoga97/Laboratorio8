package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.pdsw.samples.entities.TipoItem;

public class MyBatisTipoItemsDAO implements TipoItemDAO{

	@Inject
	private TipoItemMapper tipoItemMapper;
	
	@Override
	public TipoItem load(int id) throws PersistenceException {
		return tipoItemMapper.consultarTipoItem(id); 
	}

	@Override
	public List<TipoItem> consultarTiposItems() {
		return tipoItemMapper.consultarTiposItems();
	}

}
