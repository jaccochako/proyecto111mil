/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.integrados.controller.ABM;

import org.hibernate.Session;
import org.integrados.bd.HibernateUtiles;
import org.integrados.data.plantillas.Plantilla;
import org.integrados.exceptions.IntegradosException;

/**
 *
 * @author Yani
 */
public class PlantillaABM {
    
    public void guardar(Plantilla p) throws IntegradosException {
        Session s=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.saveOrUpdate(p);
            s.getTransaction().commit();
            s.close();            
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("falla el guardado de plantilla");
        }
    }
    
    public Plantilla get(int id) throws IntegradosException {
        Session s=null;
        Plantilla p=null;
        try {
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            p=(Plantilla) s.get(Plantilla.class, id);
            s.getTransaction().commit();
            s.close();
            return p;
        } catch(Exception e) {
            System.out.println("falla en la devolucion de plantilla " + id);
            return null;            
        }
    }
    
    public void borrar(Plantilla b) throws IntegradosException{
        Session s = null;
        try{
            s = HibernateUtiles.getSession();
            s.beginTransaction();
            s.delete(b);
            s.getTransaction().commit();
            System.out.println("Plantilla eliminada");
            s.close();
        }catch (Exception e){
            System.out.println("Error al borrar la Plantilla");
        }
    }
}