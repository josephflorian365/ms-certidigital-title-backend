package vallegrande.edu.pe.mscertidigitaltitle.service;

import vallegrande.edu.pe.mscertidigitaltitle.model.Student;

import java.util.List;

public interface StudentInterface {
    public Student findStudentByDni(String dni);
    public List<Student> findStudentAll();
}
