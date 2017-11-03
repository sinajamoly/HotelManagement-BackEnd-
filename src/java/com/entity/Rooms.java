/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sinaj
 */
@Entity
@Table(name = "rooms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r")
    , @NamedQuery(name = "Rooms.findByRoomCode", query = "SELECT r FROM Rooms r WHERE r.roomCode = :roomCode")
    , @NamedQuery(name = "Rooms.findByRoomType", query = "SELECT r FROM Rooms r WHERE r.roomType = :roomType")
    , @NamedQuery(name = "Rooms.findByRoomCapacity", query = "SELECT r FROM Rooms r WHERE r.roomCapacity = :roomCapacity")
    , @NamedQuery(name = "Rooms.findByRoomCost", query = "SELECT r FROM Rooms r WHERE r.roomCost = :roomCost")
    , @NamedQuery(name = "Rooms.findByRoomLocation", query = "SELECT r FROM Rooms r WHERE r.roomLocation = :roomLocation")})
public class Rooms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "room_code")
    private String roomCode;
    @Size(max = 10)
    @Column(name = "room_type")
    private String roomType;
    @Column(name = "room_capacity")
    private Integer roomCapacity;
    @Column(name = "room_cost")
    private Integer roomCost;
    @Size(max = 30)
    @Column(name = "room_location")
    private String roomLocation;

    public Rooms() {
    }

    public Rooms(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Integer getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(Integer roomCost) {
        this.roomCost = roomCost;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomCode != null ? roomCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.roomCode == null && other.roomCode != null) || (this.roomCode != null && !this.roomCode.equals(other.roomCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Rooms[ roomCode=" + roomCode + " ]";
    }
    
}
