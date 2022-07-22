package com.vmh.pojos;

import com.vmh.pojos.OrderDetail;
import com.vmh.pojos.User;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-07-22T20:14:00")
@StaticMetamodel(SaleOrder.class)
public class SaleOrder_ { 

    public static volatile SingularAttribute<SaleOrder, BigDecimal> amount;
    public static volatile SingularAttribute<SaleOrder, Date> createdDate;
    public static volatile SetAttribute<SaleOrder, OrderDetail> orderDetail;
    public static volatile SingularAttribute<SaleOrder, Integer> id;
    public static volatile SingularAttribute<SaleOrder, User> user;

}