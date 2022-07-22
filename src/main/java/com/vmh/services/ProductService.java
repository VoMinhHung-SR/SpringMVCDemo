/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.services;

import com.vmh.pojos.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface ProductService {
    List<Product> getProducts(Map<String, String> params, int page);
    Product getProductDetail(int id);
    boolean addOrUpdate(Product product);
}
