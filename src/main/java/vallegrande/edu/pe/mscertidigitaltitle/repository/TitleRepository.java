package vallegrande.edu.pe.mscertidigitaltitle.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vallegrande.edu.pe.mscertidigitaltitle.model.Title;

@Repository
public interface TitleRepository extends MongoRepository<Title, String> {
}
