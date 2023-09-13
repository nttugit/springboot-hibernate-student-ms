package vn.titv.spring.StudentManagement.service;

import vn.titv.spring.StudentManagement.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentBydId(int id);
}
