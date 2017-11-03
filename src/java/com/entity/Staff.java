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
@Table(name = "staff")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.findByStaffName", query = "SELECT s FROM Staff s WHERE s.staffName = :staffName")
    , @NamedQuery(name = "Staff.findByStaffPassword", query = "SELECT s FROM Staff s WHERE s.staffPassword = :staffPassword")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "staff_name")
    private String staffName;
    @Size(max = 10)
    @Column(name = "staff_password")
    private String staffPassword;

    public Staff() {
    }

    public Staff(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffName != null ? staffName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffName == null && other.staffName != null) || (this.staffName != null && !this.staffName.equals(other.staffName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Staff[ staffName=" + staffName + " ]";
    }
    
}
