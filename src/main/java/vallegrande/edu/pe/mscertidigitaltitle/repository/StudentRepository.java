package vallegrande.edu.pe.mscertidigitaltitle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vallegrande.edu.pe.mscertidigitaltitle.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByDni(String dni);
}
