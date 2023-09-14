package vn.titv.spring.StudentManagement.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.titv.spring.StudentManagement.entity.Student;
import vn.titv.spring.StudentManagement.exception.StudentException;
import vn.titv.spring.StudentManagement.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // Gom tất cả DAO của Student lại, gọi thông qua Service (Facade design pattern)
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
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id) {
        Optional<Student> found = null;
        try {
            found = this.studentService.getStudentById(id);
        } catch (Exception e) {
            throw new StudentException(e.getMessage());
        }

        if (found == null) {
            throw new StudentException("student " + id + " not found");
        }
        return ResponseEntity.ok(found);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try {
            student.setId(0);
            student = this.studentService.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        } catch (Exception e) {
            throw new StudentException(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> found = this.studentService.getStudentById(id);
        if (found == null) {
            throw new StudentException("student " + id + " not found");
        }
        try {
            student.setId(id);
            student = this.studentService.updateStudent(student);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        } catch (Exception e) {
            throw new StudentException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> found = this.studentService.getStudentById(id);
        if (found == null) {
            throw new StudentException("student " + id + " not found");
        }
        try {
            this.studentService.deleteStudentBydId(id);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        } catch (Exception e) {
            throw new StudentException(e.getMessage());
        }
    }

    // test extended query
    @GetMapping("/not-first-name/{firstName}")
    public List<Student> getStudentsNotFirstName(@PathVariable String firstName) {
        return this.studentService.getAllStudentsNotFirstName(firstName);
    }

    @GetMapping("/not-first-name-2/{firstName}")
    public List<Student> getStudentsNotFirstName2(@PathVariable String firstName) {
        return this.studentService.getAllStudentsNotFirstName2(firstName);
    }

    // Sử dụng DAO cơ bản
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
}
