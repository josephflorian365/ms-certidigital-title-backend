package vallegrande.edu.pe.mscertidigitaltitle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vallegrande.edu.pe.mscertidigitaltitle.model.Student;
import vallegrande.edu.pe.mscertidigitaltitle.repository.StudentRepository;
import vallegrande.edu.pe.mscertidigitaltitle.service.StudentService;

import java.util.List;

@RestController
public class StudentCotroller {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> list = studentService.findStudentAll();
            if (list.isEmpty() || list.size() == 0) {
                return new ResponseEntity<List<Student>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/student/dni/{dni}")
    public ResponseEntity<Student> getStudentByDni(@PathVariable String dni){
        try {
            Student  student = studentService.findStudentByDni(dni);
            if (student == null) {
                return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<Student>(student, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
