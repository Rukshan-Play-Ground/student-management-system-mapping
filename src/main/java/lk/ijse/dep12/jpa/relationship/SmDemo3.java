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

                /* Find Modules */
                Module m001 = em.find(Module.class,"M001");
                Module m002 =  em.find(Module.class,"M002");
                Module m003 =  em.find(Module.class,"M003");
                Module m004 =  em.find(Module.class,"M004");
                Module m005 =  em.find(Module.class,"M005");
                Module m006 =  em.find(Module.class,"M006");

                /* Find Students */
                Student tharindu =  em.find(Student.class,"123456789V");
                Student buddika = em.find(Student.class,"987654321V");
                Student ravindya = em.find(Student.class,"543216789V");
                Student kavindu = em.find(Student.class,"678954321V");
                Student kasun = em.find(Student.class,"937863796V");


                /* Find Users */
                User yasiya = em.find(User.class,"yasithperera");
                User asiri = em.find(User.class,"asiri");

                /* Find Batch */
                Batch dep12 = em.find(Batch.class,"B001");
                Batch cmjd300 = em.find(Batch.class,"CMJD0300");
                Batch cmjd301 = em.find(Batch.class,"CMJD0301");
                Batch ai1 = em.find(Batch.class,"AI1");
                Batch gdse81 = em.find(Batch.class,"GDSE0081");


                /* Save StudentBatchModule */
                StudentBatchModule sbm1 = new StudentBatchModule(tharindu, cmjd300, m001);
                StudentBatchModule sbm2 = new StudentBatchModule(tharindu, dep12, m004);
                StudentBatchModule sbm3 = new StudentBatchModule(buddika, dep12, m004);
                StudentBatchModule sbm4 = new StudentBatchModule(ravindya, dep12, m003);
                StudentBatchModule sbm5 = new StudentBatchModule(kavindu, ai1, m006);
                StudentBatchModule sbm6 = new StudentBatchModule(kasun, gdse81, m002);
                StudentBatchModule sbm7 = new StudentBatchModule(ravindya, cmjd301, m005);
                StudentBatchModule sbm8 = new StudentBatchModule(kasun, cmjd300, m001);


                /* Save Student Registration */
                StudentRegistration studentRegistration1 = new StudentRegistration(kasun, gdse81, yasiya, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration2 = new StudentRegistration(kavindu, ai1, yasiya, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration3 = new StudentRegistration(ravindya, dep12, asiri, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration4 = new StudentRegistration(ravindya, cmjd301, yasiya, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration5 = new StudentRegistration(buddika, dep12, yasiya, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration6 = new StudentRegistration(tharindu, cmjd300, asiri, Date.valueOf(LocalDate.now()));
                StudentRegistration studentRegistration7 = new StudentRegistration(tharindu, dep12, asiri, Date.valueOf(LocalDate.now()));

                List.of(sbm1,sbm2,sbm3,sbm4,sbm5,sbm6,sbm7,sbm8,studentRegistration1,studentRegistration2,studentRegistration3,studentRegistration4,studentRegistration5,studentRegistration6,studentRegistration7).forEach(em::persist);


                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
