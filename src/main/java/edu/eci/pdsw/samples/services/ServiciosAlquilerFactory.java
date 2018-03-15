/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import com.google.inject.Injector;
import edu.eci.pdsw.samples.services.impl.ServiciosAlquilerItemsImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;
import edu.eci.pdsw.sampleprj.dao.ClienteDAO;
import edu.eci.pdsw.sampleprj.dao.ItemDAO;
import edu.eci.pdsw.sampleprj.dao.ItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.TipoItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISClienteDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISItemDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISItemRentadoDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBatisTipoItemsDAO;


/**
 *
 * @author hcadavid
 */
public class ServiciosAlquilerFactory {

    private static ServiciosAlquilerFactory instance = new ServiciosAlquilerFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(ServiciosAlquiler.class).to(ServiciosAlquilerItemsImpl.class);
                bind(ItemDAO.class).to(MyBATISItemDAO.class);
                bind(ClienteDAO.class).to(MyBATISClienteDAO.class);
                bind(ItemRentadoDAO.class).to(MyBATISItemRentadoDAO.class);
                bind(TipoItemDAO.class).to(MyBatisTipoItemsDAO.class);
            }
        });
    }

    private ServiciosAlquilerFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosAlquiler getServiciosAlquiler(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosAlquiler.class);
    }


    public ServiciosAlquiler getServiciosAlquilerTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosAlquiler.class);
    }



    public static ServiciosAlquilerFactory getInstance(){
        return instance;
    }

}
