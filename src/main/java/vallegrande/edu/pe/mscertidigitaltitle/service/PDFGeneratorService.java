package vallegrande.edu.pe.mscertidigitaltitle.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import vallegrande.edu.pe.mscertidigitaltitle.model.Student;
import vallegrande.edu.pe.mscertidigitaltitle.model.Title;
import vallegrande.edu.pe.mscertidigitaltitle.repository.StudentRepository;
import vallegrande.edu.pe.mscertidigitaltitle.repository.TitleRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

import static java.lang.String.valueOf;

@Service
public class PDFGeneratorService {
    @Autowired
    TitleRepository titleRepository;

    public void view(HttpServletResponse response, RestTemplate restTemplate, String dni) throws IOException {
        ResponseEntity<Student> request =
                restTemplate.getForEntity(
                        "http://localhost:8090/student/dni/" + dni,
                        Student.class);
        Student students = request.getBody();
        try (Document document = new Document(PageSize.A5.rotate(), 35, 30, 50, 40)) {
            if (students.getStatus() == null) {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
            if (students.getStatus().equals("Aprobado")) {
                PdfWriter.getInstance(document, response.getOutputStream());

                document.open();
                Font fontTitleOne = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleOne.setSize(7);

                Font fontTitleTwo = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleTwo.setSize(8);

                Font fontTitlethree = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitlethree.setSize(10);

                Font fontTitleFour = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleFour.setSize(6);

                Font fontTitleFive = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleFive.setSize(8);

                Font fontTitleSix = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleSix.setSize(8);

                Font fontTitleSeven = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleSeven.setSize(8);

                Font fontTitleEight = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleEight.setSize(8);

                Font fontTitleNine = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleNine.setSize(8);

                Font fontTitleTen = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleTen.setSize(6);

                Font fontTitleEleven = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                fontTitleEleven.setSize(5);

                Paragraph paragraph = new Paragraph();
                paragraph.add(new Phrase("REPUBLICA DEL PER??\n", fontTitleOne));
                paragraph.add(new Phrase("MINISTERIO DE EDUCACI??N\n", fontTitleTwo));
                paragraph.add(new Phrase("A NOMBRE DE LA NACI??N\n", fontTitlethree));
                paragraph.add(new Phrase("EL DIRECTOR GENERAL DEL INSTITUTO DE EDUCACION SUPERIOR TECNOL??GICO PRIVADO\n", fontTitleFour));
                paragraph.add(new Phrase("????" + students.getInstitute().toUpperCase(Locale.ROOT) + "????\n" + Chunk.NEWLINE, fontTitleFive));
                paragraph.add(new Phrase("Por cuanto Don:................................................." +
                        "................" + students.getName().toUpperCase(Locale.ROOT) + "  " + students.getLastname().toUpperCase(Locale.ROOT) + "..............................................................." +
                        "........................\n" + Chunk.NEWLINE, fontTitleSix));
                paragraph.add(new Phrase("Ha cumplido satisfactoriamente con las normas y disposiciones" +
                        "reglamentarias vigentes le otorga el titulo de,le otorga el titulo de" +
                        "\n", fontTitleSeven));
                paragraph.add(new Phrase("PROFESIONAL T??CNICO EN " + students.getCareers().toUpperCase(Locale.ROOT), fontTitleEight));
                paragraph.setAlignment(Paragraph.ALIGN_CENTER);

                Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
                fontParagraph.setSize(8);

                Paragraph paragraph2 = new Paragraph();
                paragraph2.add(new Phrase("" + Chunk.NEWLINE +
                        "                                     POR TANTO:\n" +
                        "                                     Se expide el presente TITULO para que " +
                        "se le reconozca como tal.\n" +
                        "                                                                 " +
                        "                                     Dado en San" +
                        "Vicente de Ca??ete a los 17 dias del mes de Diciembre del 2021.\n" + Chunk.NEWLINE, fontParagraph));
                paragraph2.setAlignment(Paragraph.ALIGN_LEFT);

                Paragraph paragraph3 = new Paragraph();
                paragraph3.add(new Phrase(Chunk.NEWLINE));
                paragraph3.add(new Phrase(Chunk.NEWLINE));
                paragraph3.add(new Phrase("................................" +
                        "........................................................\n", fontTitleTen));
                paragraph3.add(new Phrase("Mg. F??lix Yv??n Pajares Shiozawa\n", fontTitleTen));
                paragraph3.add(new Phrase("DIRECTOR GENERAL", fontTitleEleven));
                paragraph3.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(paragraph);
                document.add(paragraph2);
                document.add(paragraph3);
                document.close();
            } else {
                response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        }
    }
}
