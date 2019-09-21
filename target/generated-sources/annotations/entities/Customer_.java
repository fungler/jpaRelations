package entities;

import entities.Address;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-18T16:19:22")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstname;
    public static volatile ListAttribute<Customer, Address> addresses;
    public static volatile ListAttribute<Customer, String> hobbies;
    public static volatile MapAttribute<Customer, String, String> phones;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, String> lastname;

}