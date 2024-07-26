package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lk.ijse.dep12.jpa.relationship.entity.Batch;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.CourseModule;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;
import lk.ijse.dep12.jpa.relationship.entity.Module;

import java.math.BigDecimal;
import java.util.List;

public class SmDemo2 {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
            EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            try {

                Module m001 = em.find(Module.class,"M001");
                Module m002 =  em.find(Module.class,"M002");
                Module m003 =  em.find(Module.class,"M003");
                Module m004 =  em.find(Module.class,"M004");


                Course dep = em.find(Course.class,"C001");
                Course cmjd = em.find(Course.class,"C002");
                Course gdse = em.find(Course.class,"C003");

                Batch gdse65 = new Batch("GDSE0081", gdse, "2 Years", new BigDecimal("400000"));
                Batch cmjd103 = new Batch("CMJD0300", cmjd, "12 Months", new BigDecimal("80000"));
                Batch cmjd102 = new Batch("CMJD0301", cmjd, "12 Months", new BigDecimal("80000"));
                Batch dep12 = new Batch("B001", dep, "6 Months", new BigDecimal("200000"));

                CourseModule cm1 = new CourseModule(dep, m001);
                CourseModule cm2 = new CourseModule(dep, m002);
                CourseModule cm3 = new CourseModule(dep, m004);

                CourseModule cm4 = new CourseModule(cmjd, m001);
                CourseModule cm5 = new CourseModule(cmjd, m002);

                CourseModule cm6 = new CourseModule(gdse, m001);
                CourseModule cm7 = new CourseModule(gdse, m002);
                CourseModule cm8 = new CourseModule(gdse, m003);
                CourseModule cm9 = new CourseModule(gdse, m004);


                List.of(dep12,cmjd103,cmjd102,gdse65,cm1,cm2,cm3,cm4,cm5,cm6,cm7,cm8,cm9).forEach(em::persist);


                em.getTransaction().commit();
            }catch (Throwable t){
                em.getTransaction().rollback();
                t.printStackTrace();
            }
        }
    }
}
