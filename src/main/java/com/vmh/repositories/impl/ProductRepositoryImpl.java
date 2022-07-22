/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.repositories.impl;

import com.vmh.pojos.Product;
import com.vmh.repositories.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;
    
    @Override
    public List<Product> getProducts(Map<String, String> params, int page) {

        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = builder.createQuery(Product.class);
        Root root = q.from(Product.class);
        // +Lay tat ca dong du lieu
        q = q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();
            if (params.containsKey("kw") == true) {
                Predicate p1 = builder.like(root.get("name").as(String.class),
                        String.format("%%%s%%", params.get("kw")));
                predicates.add(p1);
            }

            if (params.containsKey("fromPrice") == true) {
                BigDecimal fromPrice = new BigDecimal(Double.parseDouble(params.get("fromPrice")));
                Predicate p2 = builder.greaterThanOrEqualTo(root.get("price").as(String.class), fromPrice);
                predicates.add(p2);
            }

            if (params.containsKey("toPrice") == true) {
                BigDecimal toPrice = new BigDecimal(Double.parseDouble(params.get("toPrice")));
                Predicate p3 = builder.lessThanOrEqualTo(root.get("price").as(String.class), toPrice);
                predicates.add(p3);
            }

            if (params.containsKey("cateId") == true) {
                int cateId = Integer.parseInt(params.get("cateId"));
                Predicate p4 = builder.equal(root.get("category"), cateId);
                predicates.add(p4);
            }

            q = q.where(predicates.toArray(new Predicate[]{}));
        }

//        q = q.orderBy(builder.desc(root.get("id")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            int start = (page - 1) * size;
            query.setFirstResult(start);
            query.setMaxResults(size);
        }

        return query.getResultList();
    }

    @Override
    public boolean addOrUpdate(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(product);
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Product getProductDetail(int i) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = builder.createQuery(Product.class);
        Root root = q.from(Product.class);
        // +Lay tat ca dong du lieu
        q = q.select(root);

        Predicate p = builder.equal(root.get("id").as(Integer.class), i);
        q = q.where(p);

        return session.createQuery(q).getSingleResult();
    }

}
