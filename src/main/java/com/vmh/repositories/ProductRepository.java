/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.repositories;

import com.vmh.pojos.Product;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ProductRepository {
    List<Product> getProducts(String kw);
    Product getProductDetail(int id);
    boolean addOrUpdate (Product product);
}
