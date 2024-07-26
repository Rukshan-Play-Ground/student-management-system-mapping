package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.*;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;
import lk.ijse.dep12.jpa.relationship.entity.Module;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class SmDemo3 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {

                Module m001 = em.find(Module.class,"M001");
                Module m002 =  em.find(Module.class,"M002");
                Module m003 =  em.find(Module.class,"M003");
                Module m004 =  em.find(Module.class,"M004");


                Student s001 =  em.find(Student.class,"123456789V");
                Student s002 = em.find(Student.class,"987654321V");
                Student s003 = em.find(Student.class,"543216789V");
                Student s004 = em.find(Student.class,"678954321V");
                Student s005 = em.find(Student.class,"937863796V");


                User kamal = em.find(User.class,"kamal");
                User ramesh = em.find(User.class,"ramesh");


                Batch dep12 = em.find(Batch.class,"B001");
                Batch cmjd300 = em.find(Batch.class,"CMJD0300");
                Batch cmjd301 = em.find(Batch.class,"CMJD0301");

                Batch gdse81 = em.find(Batch.class,"GDSE0081");

                StudentBatchModule sbm1 = new StudentBatchModule(s001, cmjd300, m001);
                StudentBatchModule sbm2 = new StudentBatchModule(s001, dep12, m004);
                StudentBatchModule sbm3 = new StudentBatchModule(s002, dep12, m004);
                StudentBatchModule sbm4 = new StudentBatchModule(s003, dep12, m003);
                StudentBatchModule sbm6 = new StudentBatchModule(s004, gdse81, m002);
                StudentBatchModule sbm8 = new StudentBatchModule(s005, cmjd300, m001);

                StudentRegistration studentRegistration1 = new StudentRegistration(s004, gdse81, kamal, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration3 = new StudentRegistration(s003, dep12, ramesh, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration4 = new StudentRegistration(s003, cmjd301, kamal, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration5 = new StudentRegistration(s002, dep12, kamal, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration6 = new StudentRegistration(s001, cmjd300, ramesh, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration7 = new StudentRegistration(s001, dep12, ramesh, Date.valueOf(LocalDate.now()));

                List.of(sbm1,sbm2,sbm3,sbm4,sbm6,sbm8,studentRegistration1,studentRegistration3,studentRegistration4,studentRegistration5,studentRegistration6,studentRegistration7).forEach(em::persist);


                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
