package vn.titv.spring.StudentManagement.dao;

import vn.titv.spring.StudentManagement.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();

    public Student findById(int id);

    // add
    public Student save(Student student);

    // update
    public Student saveAndFlush(Student student);

    public void deleteById(int id);
}
