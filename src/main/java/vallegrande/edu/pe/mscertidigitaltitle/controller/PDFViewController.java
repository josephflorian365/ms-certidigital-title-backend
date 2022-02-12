package vallegrande.edu.pe.mscertidigitaltitle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import vallegrande.edu.pe.mscertidigitaltitle.service.PDFGeneratorService;

import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PDFViewController {
    RestTemplate restTemplate = new RestTemplate();

    private final PDFGeneratorService pdfGeneratorService;

    public PDFViewController(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/pdf/generate/{dni}")
    public Document generatePDF(HttpServletResponse response, @PathVariable String dni) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "inline; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        return this.pdfGeneratorService.view(response,restTemplate,dni);
    }
}
