package vn.titv.spring.StudentManagement.service;

import org.springframework.stereotype.Service;
import vn.titv.spring.StudentManagement.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAllStudents();

    public Optional<Student> getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentBydId(int id);

    // test extended query
    public List<Student> getAllStudentsNotFirstName(String firstName);

    public List<Student> getAllStudentsNotFirstName2(String firstName);

}
