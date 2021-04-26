package tn.esprit.spring.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.DocumentException;

import tn.esprit.spring.entity.Command;


@Service
public class pdfService {

    private static final String PDF_RESOURCES = "/templates/";
    private SpringTemplateEngine templateEngine;

    @Autowired
    public pdfService(  SpringTemplateEngine templateEngine) {
        
        this.templateEngine = templateEngine;
    }

    public File generatePdf(Optional<Command> command) throws IOException, DocumentException {
        Context context = getContext(command);
        String html = loadAndFillTemplate(context);
        return renderPdf(html);
    }


    private File renderPdf(String html) throws IOException, DocumentException {
        File file = File.createTempFile("command", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        try {
			renderer.createPDF(outputStream);
		} catch (com.lowagie.text.DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContext(Optional<Command> pack) {
    	
        Context context = new Context();
        
		context.setVariable("command", pack.get());
		context.setVariable("items", pack.get().getAllItems());
        return context;
    }

    private String loadAndFillTemplate(Context context) {
        return templateEngine.process("command", context);
    }


}

