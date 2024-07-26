package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Contact;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.entity.Module;
import lk.ijse.dep12.jpa.relationship.entity.User;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.util.List;

public class SmDemo1 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {

                Module m001 = new Module("M001", "Programming Fundamentals", 2,Module.Type.MANDATORY );
                Module m002 = new Module("M002", "Object Oriented Programming", 3, Module.Type.MANDATORY);
                Module m003 = new Module("M003", "MYSQL Database Systems", 1, Module.Type.MANDATORY);
                Module m004 = new Module("M004", "Web Development Fundamentals", 2, Module.Type.OPTIONAL);




                Student tharindu = new Student("123456789V", "Tharindu ", "Galle");
                Student buddika = new Student("987654321V", "Buddhika", "Bandarawela");
                Student ishara = new Student("456789346V", "ishara", "Gampaha");
                Student imantha = new Student("678954321V", "Imantha", "Pugoda");
                Student kasun = new Student("937863796V", "Kasun", "Panadura");

                Contact imantha1 = new Contact(imantha, "071-1234567");
                Contact imantha2 = new Contact(imantha, "072-1234567");
                Contact ishara1 = new Contact(ishara, "077-1234567");
                Contact tharindu1 = new Contact(tharindu, "088-1234567");
                Contact kasun1 = new Contact(kasun, "075-1234567");
                Contact kasun2 = new Contact(kasun, "076-1234567");
                Contact kasun3 = new Contact(kasun, "033-1234567");
                Contact buddhika1 = new Contact(buddika, "011-1234567");


                imantha.getContactList().add(imantha1);
                imantha.getContactList().add(imantha2);
                ishara.getContactList().add(ishara1);
                tharindu.getContactList().add(tharindu1);
                kasun.getContactList().add(kasun1);
                kasun.getContactList().add(kasun2);
                kasun.getContactList().add(kasun3);
                buddika.getContactList().add(buddhika1);


                User yasiya = new User("yasit", "Yasith Perera", "yasi123");
                User asiri = new User("asiri", "Asiri Sampath", "asiri123");


                Course dep = new Course("C001", "DEP");
                Course cmjd = new Course("C002", "CMJD");
                Course gdse = new Course("C003", "GDSE");


                List.of(m001,m002,m003,m004,tharindu,buddika,imantha,ishara,kasun,
                        imantha1,imantha2,ishara1,tharindu1,kasun1,kasun2,kasun3,buddhika1,
                        yasiya,asiri,dep,cmjd,gdse).forEach(em::persist);

                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
