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
@Table(name = "traveller")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traveller.findAll", query = "SELECT t FROM Traveller t")
    , @NamedQuery(name = "Traveller.findByName", query = "SELECT t FROM Traveller t WHERE t.name = :name")
    , @NamedQuery(name = "Traveller.findByPassword", query = "SELECT t FROM Traveller t WHERE t.password = :password")
    , @NamedQuery(name = "Traveller.findByIdCard", query = "SELECT t FROM Traveller t WHERE t.idCard = :idCard")
    , @NamedQuery(name = "Traveller.findByEmail", query = "SELECT t FROM Traveller t WHERE t.email = :email")
    , @NamedQuery(name = "Traveller.findByTelephone", query = "SELECT t FROM Traveller t WHERE t.telephone = :telephone")
    , @NamedQuery(name = "Traveller.findByCreditCard", query = "SELECT t FROM Traveller t WHERE t.creditCard = :creditCard")})
public class Traveller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Size(max = 10)
    @Column(name = "password")
    private String password;
    @Size(max = 10)
    @Column(name = "id_card")
    private String idCard;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private Integer telephone;
    @Size(max = 20)
    @Column(name = "credit_card")
    private String creditCard;

    public Traveller() {
    }

    public Traveller(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traveller)) {
            return false;
        }
        Traveller other = (Traveller) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Traveller[ email=" + email + " ]";
    }
    
}
