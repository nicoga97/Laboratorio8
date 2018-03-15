/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "AlquilerItems")
@SessionScoped
public class AlquilerItemsBean implements Serializable {
    
    private String nom;
    private String em;
    private String dias;
    private String itemId;
    
    private String doc;
    
    private String tel;
    private String dir;
    private List<Item> itemsDisponibles;
    private List<Item> itemsRentadosClientes;

   

    ServiciosAlquiler sp=ServiciosAlquilerFactory.getInstance().getServiciosAlquiler();
    Cliente clienteSeleccionado;
    
     public AlquilerItemsBean() {
      
    }
     
    public List<ItemRentado> getItemsRentadosClientes() throws ExcepcionServiciosAlquiler {
        return sp.consultarItemsCliente(clienteSeleccionado.getDocumento());
    }

    public void setItemsRentadosClientes(List<Item> itemsRentadosClientes) {
        this.itemsRentadosClientes = itemsRentadosClientes;
    }

     public List<Item> getItemsDisponibles() throws ExcepcionServiciosAlquiler {
        return sp.consultarItemsDisponibles();
    }

    public void setItemsDisponibles(List<Item> itemsDisponibles) {
        this.itemsDisponibles = itemsDisponibles;
    } 
    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public ServiciosAlquiler getSp() {
        return sp;
    }

    public void setSp(ServiciosAlquiler sp) {
        this.sp = sp;
    }

    
    

    public void setClienteSeleccionado(Cliente clienteSeleccionado) {
        this.clienteSeleccionado = clienteSeleccionado;
    }

    
   
    public void buttonListener() {
        try {
            sp.registrarCliente(new Cliente(nom,Integer.parseInt(doc),tel,dir,em));
        } catch (ExcepcionServiciosAlquiler ex) {
            Logger.getLogger(AlquilerItemsBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        nom="";
        doc="";
        tel="";
        dir="";
        em="";
        
    }
    
     public void buttonListener1() {
        Calendar fecha = new GregorianCalendar();
        
        fecha.add(Calendar.DAY_OF_YEAR, Integer.parseInt(dias));
        Date fechaFin=new Date(fecha.get(Calendar.YEAR),fecha.get(Calendar.MONTH),fecha.get(Calendar.DAY_OF_MONTH));
        
        try {
            sp.registrarAlquilerCliente(fechaFin, clienteSeleccionado.getDocumento(), sp.consultarItem(Integer.parseInt(itemId)), Integer.parseInt(dias));
        } catch ( Exception  ex) {
           
        }
        
        
        itemId=null;
       dias=null;
        
    }

        
   
}
