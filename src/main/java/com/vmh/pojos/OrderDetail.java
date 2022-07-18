/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.pojos;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author ASUS
 */
@Entity
@Table(name= "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private BigDecimal unitPrice;
    
    @Column(name = "num")
    private String Num;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private SaleOrder order;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(int id, BigDecimal unitPrice, String Num, SaleOrder order, Product product) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.Num = Num;
        this.order = order;
        this.product = product;
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
     * @return the Num
     */
    public String getNum() {
        return Num;
    }

    /**
     * @param Num the Num to set
     */
    public void setNum(String Num) {
        this.Num = Num;
    }

    /**
     * @return the order
     */
    public SaleOrder getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(SaleOrder order) {
        this.order = order;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
}
