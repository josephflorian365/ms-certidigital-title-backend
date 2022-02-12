package vallegrande.edu.pe.mscertidigitaltitle.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tbl_student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String careers="Anlista de Sistemas";
    private String dni = "75365805";
    private String name = "Joseph";
    private String institute = "Valle Grande";
    private String lastname = "Florian Flores";
    private String status;
}
