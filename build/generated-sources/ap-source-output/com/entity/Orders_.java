package com.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-05T01:28:28")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Date> orderCheckIn;
    public static volatile SingularAttribute<Orders, String> orderRoomCode;
    public static volatile SingularAttribute<Orders, String> orderId;
    public static volatile SingularAttribute<Orders, String> orderTravellerEmail;
    public static volatile SingularAttribute<Orders, Date> orderCheckOut;
    public static volatile SingularAttribute<Orders, Boolean> orderPaid;

}