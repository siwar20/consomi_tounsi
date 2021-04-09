package tn.esprit.spring.Oussama;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery_man")
public class delivery_manController {
    @Autowired
    delivery_manService rm;

    //Create A new delivery_man
    @PostMapping
    ResponseEntity<?> createNewDelivery_man(@RequestBody delivery_man d) {
        rm.addDelivery_man(d);
        return new ResponseEntity<>(new MessageResponseModel("Delivery_man Added "), HttpStatus.CREATED);
    }

    //Show All delivery_man
    @GetMapping
    ResponseEntity<?> getAllDelivery_man() {
        List<delivery_man> d = rm.retrieveAllDelivery_man();
        GetAlldelivery_manResponse delivery_man = new GetAlldelivery_manResponse(d);
        return new ResponseEntity<>(delivery_man, HttpStatus.OK);

    }
    //Show a delivery_man by id
    @GetMapping("/{id}")
    ResponseEntity<?> getDelivery_manById(@PathVariable int id){
        return new ResponseEntity<>(rm.Finddelivery_man(id),HttpStatus.OK);

    }
    //Delete a delivery_man by id
    @DeleteMapping ("/{id}")
    ResponseEntity<?> deleteDelivery_manById(@PathVariable int id){
        rm.deleteDelivery_man(id);
        return new ResponseEntity<>(new MessageResponseModel("delivery_man Deleted"),HttpStatus.OK);
    }
    //Update a delivery_man
    @PutMapping()
    ResponseEntity<?> updatedelivery_man(@RequestBody delivery_man d){
        rm.updatedelivery_man(d);
        return new ResponseEntity<>(new MessageResponseModel(" delivery_man Updated"), HttpStatus.OK);
    }

}
