//package vn.titv.spring.StudentManagement.dao;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
//import jakarta.persistence.TypedQuery;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import vn.titv.spring.StudentManagement.entity.Student;
//
//import java.util.List;
//
//@Repository
//public class StudentDAOImpl implements StudentDAO {
//    private EntityManager entityManager;
//
//    @Autowired
//    public StudentDAOImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Student> findAll() {
//        String jpql = "SELECT s  FROM Student s";
//        TypedQuery<Student> query = this.entityManager.createQuery(jpql, Student.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Student findById(int id) {
//        return this.entityManager.find(Student.class,id);
//    }
//
//    @Override
////    @Transactional - bỏ, vì đã sài ở service
//    public Student save(Student student) {
//         this.entityManager.persist(student);
//         return student;
//    }
//
//    @Override
////    @Transactional
//    public Student saveAndFlush(Student student) {
//        student = this.entityManager.merge(student);
//        this.entityManager.flush();
//        return student;
//    }
//
//    @Override
////    @Transactional
//    public void deleteById(int id) {
//        String jpql = "DELETE Student WHERE id=:id";
//        Query query = this.entityManager.createQuery(jpql);
//        query.setParameter("id",id);
//        query.executeUpdate();
//    }
//}
