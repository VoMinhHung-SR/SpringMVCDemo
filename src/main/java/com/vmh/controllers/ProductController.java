/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vmh.pojos.Product;
import com.vmh.services.ProductService;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
@ControllerAdvice
public class ProductController {

    @Autowired
    private ProductService productService;

    

    @GetMapping(value = "/admin/products")
    public String list(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }

    @PostMapping(value = "/admin/products")
    public String add(Model model, @ModelAttribute(value = "product") @Valid Product product,
            BindingResult result) {
        if (!result.hasErrors()) {
            if(this.productService.addOrUpdate(product))   
                return "redirect:/";
            else
                model.addAttribute("errMsg", "Loi Upload");
        }

        return "products";
    }
}
