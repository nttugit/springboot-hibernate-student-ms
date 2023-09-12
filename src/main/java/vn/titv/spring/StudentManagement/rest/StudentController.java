package vn.titv.spring.StudentManagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.titv.spring.StudentManagement.dao.StudentDAO;
import vn.titv.spring.StudentManagement.entity.Student;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentDAO studentDAO;
    @Autowired
    public StudentController(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public List<Student> getStudents(){
        return this.studentDAO.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id){
        return this.studentDAO.findById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return this.studentDAO.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
        student.setId(id);
        return this.studentDAO.saveAndFlush(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
         this.studentDAO.deleteById(id);
         return "Ok";
    }

}
