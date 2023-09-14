package vn.titv.spring.StudentManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import vn.titv.spring.StudentManagement.entity.Student;

import java.util.List;


// Sử sụn JpaRepository thì không cần StudentDAO và StudentDAOImpl nữa
//@Repository - Sử dụng Spring data rest, không cần cái này nữa
//@RepositoryRestController(path = "students") // - không cần dùng Service luôn
//public interface StudentRepository extends JpaRepository<Student,Integer> {
//}

// Mở rộng thêm truy vấn (có quy tắc)
@RepositoryRestController(path = "students")
public interface StudentRepository extends JpaRepository<Student,Integer> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // Tìm kiếm sinh viên không chứa firstName đầu vào
    public List<Student> findByFirstNameNot(String firstName);

    @Query("SELECT s FROM Student s WHERE s.firstName NOT LIKE %?1%")
    public List<Student> findByFirstNameNot2(String firstName);

}