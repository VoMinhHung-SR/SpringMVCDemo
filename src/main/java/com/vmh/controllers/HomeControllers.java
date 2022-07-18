/*  
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.controllers;


import com.vmh.pojos.Category;
import com.vmh.pojos.User;
import com.vmh.services.CategoryService;
import com.vmh.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author ASUS
 */
@Controller
@ControllerAdvice
public class HomeControllers {
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService  productService;
    
    @ModelAttribute
    public void commonsAttribute(Model model){
        model.addAttribute("categories", this.categoryService.getCategory());
    }
    
    @RequestMapping(value = "/")
    public String index(Model model, @RequestParam(value = "kw", 
            required = false, defaultValue = "") String kw){     
        model.addAttribute("products", this.productService.getProducts(kw));
        return "index";
    }
    
    @RequestMapping(value="/show-post")
    public String showWord(Model model, @ModelAttribute(value = "user") User user){
        if (user.getFirstName() != null && user.getLastName() != null)
            model.addAttribute("fullWord", user.getFirstName() + " " + user.getLastName());
        return "index";
    }
    
    @RequestMapping(value = "/cart")
    public String cart(Model model){     
        return "cart";
    }
    
    @GetMapping(value = "/products/{id}")
    public String detail(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("product", this.productService.getProductDetail(id));
        return "detail";
    }
    
}
