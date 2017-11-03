/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.bussiness.OrdersClass;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sinaj
 */
@WebServlet(name = "BookRoomServlet", urlPatterns = {"/BookRoomServlet"})
public class BookRoomServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            OrdersClass oc=new OrdersClass();
            HttpSession session=request.getSession(false);  
            String email=(String)session.getAttribute("email");   
            Date checkIn=new Date();
            Date checkOut=new Date();
            String in=request.getParameter("checkIn");
            String out1=request.getParameter("checkOut");
            DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            boolean paid=Boolean.parseBoolean(request.getParameter("paid"));
            try {
                checkIn=df.parse(in);
            } catch (ParseException ex) {
                out.println(ex);
            }
            try {
                checkOut=df.parse(out1);
            } catch (ParseException ex) {
                out.println(ex);
            }
            
            if(oc.checkAvailability(request.getParameter("roomCode"), checkIn, checkOut)){
                oc.order(email,checkIn,checkOut,request.getParameter("roomCode"), paid);
                request.setAttribute("message", "Order has been added succesfully");
                response.sendRedirect("BookRoom.jsp");
            }            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
