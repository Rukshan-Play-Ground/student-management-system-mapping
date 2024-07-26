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




                Student buddika = new Student("987654321V", "Buddhika", "Bandarawela");
                Student ishara = new Student("456789346V", "ishara", "Gampaha");
                Student tharindu = new Student("123456789V", "Tharindu ", "Galle");
                Student nimal = new Student("937863796V", "Kasun", "Panadura");
                Student imantha = new Student("678954321V", "Imantha", "Pugoda");

                Contact c001 = new Contact(imantha, "071-1234567");
                Contact c002 = new Contact(imantha, "072-1234567");
                Contact c003 = new Contact(ishara, "077-1234567");
                Contact c004 = new Contact(tharindu, "088-1234567");
                Contact c005 = new Contact(nimal, "075-1234567");
                Contact c006 = new Contact(nimal, "076-1234567");
                Contact c007 = new Contact(nimal, "033-1234567");
                Contact c008 = new Contact(buddika, "011-1234567");


                imantha.getContactList().add(c001);
                imantha.getContactList().add(c002);
                ishara.getContactList().add(c003);
                tharindu.getContactList().add(c004);
                nimal.getContactList().add(c005);
                nimal.getContactList().add(c006);
                nimal.getContactList().add(c007);
                buddika.getContactList().add(c008);


                User kamal = new User("kamal", "Nimal ", "kamal1234");
                User ramesh = new User("ramesh", "Ramesh", "ramesh2345");


                Course dep = new Course("C001", "DEP");
                Course cmjd = new Course("C002", "CMJD");
                Course gdse = new Course("C003", "GDSE");


                List.of(m001,m002,m003,m004,tharindu,buddika,imantha,ishara,nimal,
                        c001,c003,c002,c004,c005,c006,c007,c008,
                        kamal,ramesh,dep,cmjd,gdse).forEach(em::persist);

                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
