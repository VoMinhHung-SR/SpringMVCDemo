/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.services;

import com.vmh.pojos.Product;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface ProductService {
    List<Product> getProducts(String kw);
    Product getProductDetail(int id);
}
