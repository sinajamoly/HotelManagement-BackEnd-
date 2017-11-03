/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bussiness;

import com.entity.Staff;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sinaj
 */
public class StaffClass {
    
    public List<Staff> listStaff(){
        EntityManager em;
        EntityManagerFactory emf;
        emf=Persistence.createEntityManagerFactory("HotelAssignment1PU");
        em=emf.createEntityManager();
        em.getTransaction().begin(); 

        List<Staff> listStaff=em.createNamedQuery("Staff.findAll",Staff.class).getResultList();
        return listStaff;
    }
    
    public boolean loginStaff(String email,String password){
        boolean state=false;
        for(Staff t:listStaff()){
            if(email.equals(t.getStaffName()) && password.equals(t.getStaffPassword())){
                state= true;
            }else{
                
            }
        }
        return state;
    }    

    
}
