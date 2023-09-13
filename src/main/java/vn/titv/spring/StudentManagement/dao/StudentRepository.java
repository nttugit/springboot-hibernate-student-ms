package vn.titv.spring.StudentManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.titv.spring.StudentManagement.entity.Student;


// Sử sụn JpaRepository thì không cần StudentDAO và StudentDAOImpl nữa
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
