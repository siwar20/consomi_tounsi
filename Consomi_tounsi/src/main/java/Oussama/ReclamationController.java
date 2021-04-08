package Oussama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
    @Autowired
    ReclamationService rm;
    //Create A new Reclamation
    @PostMapping
    ResponseEntity<?> createNewReclamation( @RequestBody reclamation r){
        rm.addReclamation(r);
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
    ResponseEntity<?> getReclamationById(@PathVariable Long id){
        return new ResponseEntity<>(rm.FindReclamation(id),HttpStatus.OK);

    }
    //Delete an Reclamation by id
    @DeleteMapping ("/{id}")
    ResponseEntity<?> deleteReclamationById(@PathVariable Long id){
        rm.deleteReclamation(id);
        return new ResponseEntity<>(new MessageResponseModel("Reclamation Deleted"),HttpStatus.OK);

    }
    //Update an Reclamation
    @PutMapping("/{id}")
    ResponseEntity<?> updateReclamation(@PathVariable Long id ,@RequestBody reclamation r){

        rm.updateReclamation(id,r);
        return new ResponseEntity<>(new MessageResponseModel(" Reclamation Updated"), HttpStatus.OK);
    }
    //

}