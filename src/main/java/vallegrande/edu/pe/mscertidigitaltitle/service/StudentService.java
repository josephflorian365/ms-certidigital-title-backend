package vallegrande.edu.pe.mscertidigitaltitle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vallegrande.edu.pe.mscertidigitaltitle.model.Student;
import vallegrande.edu.pe.mscertidigitaltitle.repository.StudentRepository;

import java.util.List;


@Service
public class StudentService implements StudentInterface{

    @Autowired
    StudentRepository studentRepository;


    @Override
    public Student findStudentByDni(String dni) {
        return studentRepository.findByDni(dni);
    }

    @Override
    public List<Student> findStudentAll() {
        return studentRepository.findAll();
    }
}
