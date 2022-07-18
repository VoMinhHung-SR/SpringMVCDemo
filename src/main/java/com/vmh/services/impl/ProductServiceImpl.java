/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.services.impl;

import com.vmh.pojos.Product;
import com.vmh.repositories.ProductRepository;
import com.vmh.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getProducts(String kw) {
       return this.productRepository.getProducts(kw);
    }

    @Override
    public Product getProductDetail(int i) {
       return this.productRepository.getProductDetail(i);
    }
    
}
