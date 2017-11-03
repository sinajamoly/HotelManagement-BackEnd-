/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sinaj
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o")
    , @NamedQuery(name = "Orders.findByOrderId", query = "SELECT o FROM Orders o WHERE o.orderId = :orderId")
    , @NamedQuery(name = "Orders.findByOrderTravellerEmail", query = "SELECT o FROM Orders o WHERE o.orderTravellerEmail = :orderTravellerEmail")
    , @NamedQuery(name = "Orders.findByOrderCheckIn", query = "SELECT o FROM Orders o WHERE o.orderCheckIn = :orderCheckIn")
    , @NamedQuery(name = "Orders.findByOrderCheckOut", query = "SELECT o FROM Orders o WHERE o.orderCheckOut = :orderCheckOut")
    , @NamedQuery(name = "Orders.findByOrderRoomCode", query = "SELECT o FROM Orders o WHERE o.orderRoomCode = :orderRoomCode")
    , @NamedQuery(name = "Orders.findByOrderPaid", query = "SELECT o FROM Orders o WHERE o.orderPaid = :orderPaid")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "order_id")
    private String orderId;
    @Size(max = 20)
    @Column(name = "order_traveller_email")
    private String orderTravellerEmail;
    @Column(name = "order_check_in")
    @Temporal(TemporalType.DATE)
    private Date orderCheckIn;
    @Column(name = "order_check_out")
    @Temporal(TemporalType.DATE)
    private Date orderCheckOut;
    @Size(max = 20)
    @Column(name = "order_room_code")
    private String orderRoomCode;
    @Column(name = "order_paid")
    private Boolean orderPaid;

    public Orders() {
    }

    public Orders(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderTravellerEmail() {
        return orderTravellerEmail;
    }

    public void setOrderTravellerEmail(String orderTravellerEmail) {
        this.orderTravellerEmail = orderTravellerEmail;
    }

    public Date getOrderCheckIn() {
        return orderCheckIn;
    }

    public void setOrderCheckIn(Date orderCheckIn) {
        this.orderCheckIn = orderCheckIn;
    }

    public Date getOrderCheckOut() {
        return orderCheckOut;
    }

    public void setOrderCheckOut(Date orderCheckOut) {
        this.orderCheckOut = orderCheckOut;
    }

    public String getOrderRoomCode() {
        return orderRoomCode;
    }

    public void setOrderRoomCode(String orderRoomCode) {
        this.orderRoomCode = orderRoomCode;
    }

    public Boolean getOrderPaid() {
        return orderPaid;
    }

    public void setOrderPaid(Boolean orderPaid) {
        this.orderPaid = orderPaid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Orders[ orderId=" + orderId + " ]";
    }
    
}
