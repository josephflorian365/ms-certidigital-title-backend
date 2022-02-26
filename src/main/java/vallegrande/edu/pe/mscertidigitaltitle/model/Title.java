package vallegrande.edu.pe.mscertidigitaltitle.model;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.File;

@Data
@Document(collection = "requirements")
public class Title {

    @Id
    private String id;
    private String description;
    private String document;
}
