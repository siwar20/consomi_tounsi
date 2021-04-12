package tn.esprit.spring.Oussama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.mail.MailService;
import tn.esprit.spring.pdf.PdfService;

import javax.mail.MessagingException;
import java.util.List;
@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
    @Autowired
    ReclamationService rm;
    @Autowired
    MailService mailService;
    @Autowired
    PdfService pdfService;

    //Create A new Reclamation
    @PostMapping
    ResponseEntity<?> createNewReclamation( @RequestBody reclamation r) throws MessagingException {
        rm.addReclamation(r);
        mailService.sendWithAttachment(r,pdfService.toPDF(r.getId()));
        return new ResponseEntity<>(new MessageResponseModel("Reclamation Added "), HttpStatus.CREATED);
    }
    //Show All reclamation
    @GetMapping
    ResponseEntity<?> getAllReclamation(){
        List<reclamation> r=rm.retrieveAllReclamation();
        GetAllReclamationResponse reclamations = new GetAllReclamationResponse(r);
        return new ResponseEntity<>(reclamations,HttpStatus.OK);
    }
    //Show an reclamation by id
    @GetMapping("/{id}")
    ResponseEntity<?> getReclamationById(@PathVariable int id){
        return new ResponseEntity<>(rm.FindReclamation(id),HttpStatus.OK);

    }
    //Delete an Reclamation by id
    @DeleteMapping ("/{id}")
    ResponseEntity<?> deleteReclamationById(@PathVariable int id){
        rm.deleteReclamation(id);
        return new ResponseEntity<>(new MessageResponseModel("Reclamation Deleted"),HttpStatus.OK);

    }
    //Update an Reclamation
    @PutMapping()
    ResponseEntity<?> updateReclamation(@RequestBody reclamation r){

        rm.updateReclamation(r);
        return new ResponseEntity<>(new MessageResponseModel(" Reclamation Updated"), HttpStatus.OK);
    }
    //

}