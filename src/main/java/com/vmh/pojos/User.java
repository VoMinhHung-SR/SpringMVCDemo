/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.pojos;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "user")
public class User  implements Serializable{
    private static final long serialVersion = 3L;
    private static final String USER = "ROLE_USER";
    private static final String ADMIN = "ROLE_ADMIN";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;  
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",
            message = "{user.email.error.invalidMsg}")
    private String email;
    private String phone;
    @Size(min = 1, max = 45, message = "{user.username.sizeMsg}")
    private String username;
    @NotEmpty(message = "{user.password.sizeMsg}")
    private String password;
    private Boolean active;
    @Column(name="user_role")
    private String userRole;
    
    @Transient
    private String confirmPassword;
    
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the USER
     */
    public static String getUSER() {
        return USER;
    }

    /**
     * @return the ADMIN
     */
    public static String getADMIN() {
        return ADMIN;
    }

    /**
     * @return the serialVersion
     */
    public static long getSerialVersion() {
        return serialVersion;
    }

    
}
    
    
   
    
    
    
