package Oussama;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
	@Autowired
	DeliveryManager rm;
    //Create A new Reclamation
    @PostMapping
    ResponseEntity<?> createNewreclamation( @RequestBody Reclamation r){
        rm.addReclamation(r);
        return new ResponseEntity<>(new MessageResponseModel("Reclamation Added "), HttpStatus.CREATED);
    }
    //Show All reclamation
    @GetMapping
    ResponseEntity<?> getAllReclamation(){
        List<Reclamation> r=rm.retrieveAllReclamation();
        GetAllReclamationResponse reclamations = new GetAllReclamationResponse(r);
        return new ResponseEntity<>(reclamations,HttpStatus.OK);

}
