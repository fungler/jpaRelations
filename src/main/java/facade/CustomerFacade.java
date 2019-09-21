package facade;

import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerFacade {
    
    EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();

    Customer getCustomer(int id) {
        try {
            Customer res = (Customer)em.createQuery("SELECT c FROM Customer c WHERE c.id =" + id).getSingleResult();
            return res;
        } finally {
            em.close();
        }
    }
    
    List<Customer> getCustomers() {
        try {
            List<Customer> res = em.createQuery("SELECT c FROM Customer c").getResultList();
            return res;
        } finally {
            em.close();
        }
    }
    Customer addCustomer(Customer cust) {
        try {
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            
            return cust;
        } finally {
            em.close();
        }
    }
    Customer deleteCustomer(int id) {
        try {
            Customer foundCust = (Customer)em.createQuery("SELECT c FROM Customer c WHERE c.id = " + id).getSingleResult();
            em.createQuery("DELETE FROM Customer c WHERE c.id =" + id).executeUpdate();
            
            return foundCust;
        } finally {
            em.close();
        }
    }
    
    Customer editCustomer(Customer cust) {
        em.createQuery("UPDATE Customer "
                + "SET c.firstname="+cust.getFirstname()+", c.lastname="+cust.getLastname()+" "
                        + "WHERE c.id="+cust.getId()).executeUpdate();
        
        return cust;
    }

}
