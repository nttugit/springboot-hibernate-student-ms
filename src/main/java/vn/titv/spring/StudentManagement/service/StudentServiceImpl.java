package vn.titv.spring.StudentManagement.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.StudentManagement.dao.StudentRepository;
import vn.titv.spring.StudentManagement.entity.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        return this.studentRepository.findById(id);
    }

    @Override
    @Transactional
    // Vì khi sử dụng service trong đó có nhiều DAO, ta cần rollback hết DAO, không chỉ riêng 1 DAO nhất định
    public Student addStudent(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return this.studentRepository.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudentBydId(int id) {
        this.studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudentsNotFirstName(String firstName) {
        return this.studentRepository.findByFirstNameNot(firstName);
    }

    @Override
    public List<Student> getAllStudentsNotFirstName2(String firstName) {
        return this.studentRepository.findByFirstNameNot2(firstName);
    }

    // Giờ không cần dùng DAO chỗ này, vì đã có StudentRepository
//    private StudentDAO studentDAO;
//
//    @Autowired
//    public StudentServiceImpl(StudentDAO studentDAO){
//        this.studentDAO = studentDAO;
//    }
//
//    @Override
//    public List<Student> getAllStudents() {
//        return this.studentDAO.findAll();
//    }
//
//    @Override
//    public Student getStudentById(int id) {
//        return this.studentDAO.findById(id);
//    }
//
//    @Override
//    @Transactional // Vì khi sử dụng service trong đó có nhiều DAO, ta cần rollback hết DAO, không chỉ riêng 1 DAO nhất định
//    public Student addStudent(Student student) {
//        return this.studentDAO.save(student);
//    }
//
//    @Override
//    @Transactional
//    public Student updateStudent(Student student) {
//        return this.studentDAO.saveAndFlush(student);
//    }
//
//    @Override
//    @Transactional
//    public void deleteStudentBydId(int id) {
//        this.studentDAO.deleteById(id);
//    }
}
