/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.repositories.impl;

import com.vmh.pojos.Product;
import com.vmh.repositories.ProductRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
        
    @Override
    public List<Product> getProducts(String kw) {
        
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = builder.createQuery(Product.class);
        Root root = q.from(Product.class);
        // +Lay tat ca dong du lieu
        q = q.select(root);
        
        if(!kw.isEmpty() && kw != null ){
            Predicate p =  builder.like(root.get("name").as(String.class), 
                    String.format("%%%s%%", kw));
            q = q.where(p);
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean addOrUpdate(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Product getProductDetail(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = builder.createQuery(Product.class);
        Root root = q.from(Product.class);
        // +Lay tat ca dong du lieu
        q = q.select(root);
        
        Predicate p =  builder.equal(root.get("id").as(Integer.class), i);
        q = q.where(p);
        
        return session.createQuery(q).getSingleResult();
    }
    
}
