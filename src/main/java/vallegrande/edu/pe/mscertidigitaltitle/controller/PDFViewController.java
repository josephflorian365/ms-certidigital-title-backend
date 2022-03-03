package vallegrande.edu.pe.mscertidigitaltitle.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import vallegrande.edu.pe.mscertidigitaltitle.service.PDFGeneratorService;

import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;

import java.awt.print.Book;
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

    @Operation(summary = "Generar titulo en pdf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Titulo generado",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Dni inválido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Dni no encontrado",
                    content = @Content) })
    @GetMapping("/pdf/generate/{dni}")
    public void generatePDF(HttpServletResponse response, @PathVariable String dni) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "inline; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        pdfGeneratorService.view(response,restTemplate,dni);
    }
}
