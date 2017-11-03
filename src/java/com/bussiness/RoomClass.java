/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bussiness;

import com.entity.Rooms;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sinaj
 */
public class RoomClass {
    public boolean add(String roomCode, String roomType, int roomCapacity,String roomLocation,int roomCost){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
            
        Rooms r=new Rooms();
        r.setRoomCode(roomCode);
        r.setRoomType(roomType);
        r.setRoomCapacity(roomCapacity);
        r.setRoomLocation(roomLocation);
        r.setRoomCost(roomCost);
        
        
        
        //_________Create_________________
        em.persist(r);
        em.getTransaction().commit();
        return true;
    }
    
    public List<Rooms> listRooms(){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin(); 

        List<Rooms> listRooms=em.createNamedQuery("Rooms.findAll",Rooms.class).getResultList();
        return listRooms;
    }

    public void deleteRoom(String roomCode){
            EntityManager em;
            EntityManagerFactory emf;
            emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
            em=emf.createEntityManager();
            em.getTransaction().begin();
            Rooms ttb=em.find(Rooms.class, roomCode);
            em.remove(ttb);
            em.getTransaction().commit();        
    }
    
    public void editRoom(String roomCode, String roomType, int roomCapacity,String roomLocation,int roomCost){

        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
        Rooms r=new Rooms();
        
        r=em.createQuery("SELECT r FROM Rooms r WHERE r.roomCode = :roomCode",Rooms.class).setParameter("roomCode", roomCode).getSingleResult();
        
        if(roomType!=null){
            r.setRoomType(roomType);       
        }if(roomCapacity!=0){
            r.setRoomCapacity(roomCapacity);            
        }if(roomLocation!=null){
            r.setRoomLocation(roomLocation);            
        }if(roomCapacity!=0){
            r.setRoomCost(roomCost);            
        }
        em.merge(r);
        em.getTransaction().commit();        
    }
    
    public List<Rooms> listRoom1(String searchValue,String type){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
        List<Rooms> listRooms=em.createNamedQuery("Rooms.findAll",Rooms.class).getResultList();
        if(type.endsWith("roomType")){
            listRooms=em.createNamedQuery("SELECT r FROM Rooms r WHERE r.roomType = :roomType",Rooms.class).setParameter("roomType", searchValue).getResultList();
        }else if(type.endsWith("roomCapacity")){
            listRooms=em.createNamedQuery("SELECT r FROM Rooms r WHERE r.roomCapacity = :roomCapacity",Rooms.class).setParameter("roomCapacity", searchValue).getResultList();
        }
        return listRooms;
    }
    
}
