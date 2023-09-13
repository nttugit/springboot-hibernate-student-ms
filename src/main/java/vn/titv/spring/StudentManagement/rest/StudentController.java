package vn.titv.spring.StudentManagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.titv.spring.StudentManagement.dao.StudentDAO;
import vn.titv.spring.StudentManagement.entity.Student;
import vn.titv.spring.StudentManagement.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
//    private StudentDAO studentDAO;
//    @Autowired
//    public StudentController(StudentDAO studentDAO){
//        this.studentDAO = studentDAO;
//    }
//
//    @GetMapping
//    public List<Student> getStudents(){
//        return this.studentDAO.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable int id){
//        return this.studentDAO.findById(id);
//    }
//
//    @PostMapping
//    public Student createStudent(@RequestBody Student student){
//        return this.studentDAO.save(student);
//    }
//
//    @PutMapping("/{id}")
//    public Student updateStudent(@PathVariable int id, @RequestBody Student student){
//        student.setId(id);
//        return this.studentDAO.saveAndFlush(student);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteStudent(@PathVariable int id){
//         this.studentDAO.deleteById(id);
//         return "Ok";
//    }

    // Chuyển thành service (facade design pattern)
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return this.studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student found = this.studentService.getStudentById(id);
        if (found != null) {
            return ResponseEntity.ok(found);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        student.setId(0);
        student = this.studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student found = this.studentService.getStudentById(id);
        if (found != null) {
            student.setId(id);
            student = this.studentService.updateStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Student found = this.studentService.getStudentById(id);
        if (found != null) {
            this.studentService.deleteStudentBydId(id);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
