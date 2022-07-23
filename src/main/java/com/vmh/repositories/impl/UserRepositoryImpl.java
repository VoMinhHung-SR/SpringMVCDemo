/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vmh.repositories.impl;

import com.vmh.pojos.User;
import com.vmh.repositories.UserRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public List<User> getUsers(String username) {
        
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> q = builder.createQuery(User.class);
        Root root = q.from(User.class);
        
        if(!username.isEmpty()){
            Predicate p = builder.equal(root.get("username")
                    .as(String.class),username.trim());
            q = q.where(p);
        }
        Query query = session.createQuery(q);
        return query.getResultList();
    }
    
}
