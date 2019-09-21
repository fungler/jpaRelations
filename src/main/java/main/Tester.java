package main;

import entities.Address;
import entities.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Tester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        Customer c1 = new Customer("John", "Mogensen");
        Customer c2 = new Customer("Bob", "Mell");
        Customer c3 = new Customer("Hans", "Hansi");
        
        c1.addHobby("Golf");
        c1.addHobby("Ski");
        c1.addHobby("Fodbold");
        c1.addPhone("12344556", "Mobil");
        //c1.addAddress(new Address("Tordisvej", "Backsword", c1));
        c1.addAddress(new Address("Tordisvej", "Backsword"));
        
        c2.addHobby("Videospil");
        c2.addHobby("Basketball");
        c2.addPhone("33333333", "Arbj. Mobil");
        
        c3.addHobby("Strik");
        //c3.addAddress(new Address("Odinsvej", "Lyngby", c3));
        c3.addAddress(new Address("Odinsvej", "Lyngby"));
        c3.addAddress(new Address("Ullasvej", "Virum"));
        
        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        //Persistence.generateSchema("pu", null);
    }
}
