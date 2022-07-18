/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.pojos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "user")
public class User  implements Serializable{

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;  
    private String email;
    private String phone;
    private String username;
    private String password;
    private Boolean active;
    private String userRole;

    @OneToMany(mappedBy = "user")
    private Set<SaleOrder> saleOrders;
    
    public User() {
    }

    public User(int id, String first_name, String last_name, String email, String phone, String username, String password, String user_role) {
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.userRole = user_role;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return the saleOrders
     */
    public Set<SaleOrder> getSaleOrders() {
        return saleOrders;
    }

    /**
     * @param saleOrders the saleOrders to set
     */
    public void setSaleOrders(Set<SaleOrder> saleOrders) {
        this.saleOrders = saleOrders;
    }

    
}
    
    
   
    
    
    
