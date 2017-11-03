/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bussiness;

import com.entity.Orders;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sinaj
 */
public class OrdersClass {
    public boolean order(String email,Date checkIn,Date checkOut,String roomCode,boolean paid){


        
            EntityManager em;
            EntityManagerFactory emf;
            emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
            em=emf.createEntityManager();
            em.getTransaction().begin();
            
            Orders o=new Orders();    
            int num=listOrders().size();
            String sNum=Integer.toString(num);
            o.setOrderId(sNum +email + roomCode);
            o.setOrderTravellerEmail(email);
            o.setOrderCheckIn(checkIn);
            o.setOrderCheckOut(checkOut);
            o.setOrderRoomCode(roomCode);
            o.setOrderPaid(paid);
            em.persist(o);
            em.getTransaction().commit();
        
        return checkAvailability(roomCode, checkIn, checkOut);
        //_________Create_________________
    }
    
    public void deleteOrder(String OrderId){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
        Orders o=em.find(Orders.class, OrderId);
        em.remove(o);
        em.getTransaction().commit();        
    }
 
    public List<Orders> listOrders(){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin(); 

        List<Orders> orders=em.createNamedQuery("Orders.findAll",Orders.class).getResultList();
        
        return orders;
    }
    
    public List<Orders> listOrders1(String room){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin();
        List<Orders> listOrders=em.createQuery("SELECT o FROM Orders o WHERE o.orderRoomCode = :orderRoomCode",Orders.class).setParameter("orderRoomCode", room).getResultList();
        return listOrders;
    }
    
    public boolean checkAvailability(String room,Date check_in,Date check_out){
        boolean s=true;
        for(Orders oo:listOrders1(room)){
        //______________getting all the dates for room_____________________________
            if(checkBetween(check_in, check_out, oo.getOrderCheckIn(), oo.getOrderCheckOut())==false){
                s=false;
            }
        //______________getting all the dates for room____________________________
        }
        
        return s;
    }
    
    public boolean checkBetween(Date in,Date out, Date checkin,Date checkout ){
        boolean status=false;
        if(checkin.after(out) || checkin.before(in)){
            if(checkout.after(out)||checkout.before(in)){
                status=true;
            }
        }
        return status;
    }
    
    
    
}
