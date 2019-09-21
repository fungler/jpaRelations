/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    
//    @OneToMany(cascade = CascadeType.PERSIST)
//    @JoinColumn(name="address_id")
    //private Address address;
//    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customer")
    
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Address> addresses = new ArrayList();
    
    @ElementCollection(fetch = FetchType.LAZY)
    @MapKeyColumn(name = "PHONE")
    @Column(name="Description")

    private Map<String,String> phones = new HashMap();
    
    @ElementCollection
    @Column(name="HOBBY")
    private List<String> hobbies = new ArrayList();

    
    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public Customer() {
    }
    
    public void addAddress(Address a) {
        addresses.add(a);
    }
    
    public String getHobbies() {
        
        String result = "";
        
        for (int i = 0; i < hobbies.size(); i++) {
            if (i != hobbies.size() - 1) 
                result += hobbies.get(i) + ", ";
            else
                result += hobbies.get(i);
        }
        
        return result;
    }
    
    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void addPhone(String phoneNo, String description){
        phones.put(phoneNo, description);
    }
    
    public String getPhoneDescription(String phoneNo){
        return phones.get(phoneNo);
    }

    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
