package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

public class HelloJpa {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {

                em.getTransaction().commit();
                System.out.println("Entity Manager Factory: " + emf);
                System.out.println("Entity Manager: " + em);
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
