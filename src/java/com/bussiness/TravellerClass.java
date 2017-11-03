/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bussiness;

import com.entity.Traveller;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sinaj
 */
public class TravellerClass {
    
    public boolean add(String name,String password,String idCard,String email,int telephone,String creditcard){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
            
        Traveller t=new Traveller();
        
        t.setName(name);
        t.setPassword(password);
        t.setIdCard(idCard);
        t.setEmail(email);
        t.setTelephone(telephone);
        t.setCreditCard(creditcard);
        
        //_________Create_________________
        em.persist(t);
        em.getTransaction().commit();
        return true;
    }
    
    public List<Traveller> listTraveller(){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin(); 

        List<Traveller> listTraveller=em.createNamedQuery("Traveller.findAll",Traveller.class).getResultList();
        return listTraveller;
    }
    
    public boolean loginTraveller(String email,String password){
        boolean state=false;
        for(Traveller t:listTraveller()){
            if(email.equals(t.getEmail()) && password.equals(t.getPassword())){
                state= true;
            }else{
                
            }
        }
        return state;
    }
    
    public void deleteTraveller(String email){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
        Traveller ttb=em.find(Traveller.class, email);
        em.remove(ttb);
        em.getTransaction().commit();
    }
    
    public List<Traveller> listTraveller1(String name,String type){
        List<Traveller> t=null;
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
        List<Traveller> listTraveller=em.createNamedQuery("Traveller.findAll",Traveller.class).getResultList();
        
        if("idCard".endsWith(type)){
            listTraveller=em.createQuery("SELECT t FROM Traveller t WHERE t.idCard = :idCard",Traveller.class).setParameter("idCard", name).getResultList();
            
        }
            else if(type.equals("email")){
            listTraveller=em.createQuery("SELECT t FROM Traveller t WHERE t.email = :email",Traveller.class).setParameter("email", name).getResultList();
                        
        }
            else if("telephone".endsWith(type)){
            listTraveller=em.createQuery("SELECT t FROM Traveller t WHERE t.telephone = :telephone",Traveller.class).setParameter("telephone",name).getResultList();
                        
        }
            else if("name".endsWith(type)){
            listTraveller=em.createQuery("SELECT t FROM Traveller t WHERE t.name = :name",Traveller.class).setParameter("name", name).getResultList();
                        
        }
        return listTraveller;
    }
    
    
}
