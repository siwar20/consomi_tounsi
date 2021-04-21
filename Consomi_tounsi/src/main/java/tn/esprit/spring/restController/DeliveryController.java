package tn.esprit.spring.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.Oussama.GetAllDeliveryResponse;
import tn.esprit.spring.Oussama.MessageResponseModel;
import tn.esprit.spring.entity.Delivery;
import tn.esprit.spring.service.impl.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    DeliveryService rm;

    //Create A new Delivery
    @PostMapping("/post")
    ResponseEntity<?> createNewDelivery(@RequestBody Delivery d) {
        rm.addDelivery(d);
        return new ResponseEntity<>(new MessageResponseModel("Delivery Added "), HttpStatus.CREATED);
    }

    //Show All delivery
    @GetMapping
    ResponseEntity<?> getAllDelivery() {
        List<Delivery> d = rm.retrieveAllDelivery();
        GetAllDeliveryResponse Delivery = new GetAllDeliveryResponse();
        return new ResponseEntity<>(Delivery, HttpStatus.OK);

    }
    //Show a delivery by id
    @GetMapping("/{id}")
    ResponseEntity<?> getDeliveryById(@PathVariable int id){
        return new ResponseEntity<>(rm.FindDelivery(id),HttpStatus.OK);

    }
    //Delete a delivery by id
    @DeleteMapping ("/{id}")
    ResponseEntity<?> deleteDeliveryById(@PathVariable int id){
        rm.deleteDelivery(id);
        return new ResponseEntity<>(new MessageResponseModel("Delivery Deleted"),HttpStatus.OK);
    }
    //Update a delivery
    @PutMapping()
    ResponseEntity<?> updateDelivery(@RequestBody Delivery d){
        rm.updateDelivery(d);
        return new ResponseEntity<>(new MessageResponseModel(" Delivery Updated"), HttpStatus.OK);
    }
    @PutMapping("/prix")
    ResponseEntity<?> getPrixDelivery(@RequestBody Delivery d){
        double prix=rm.calculFrais(d);
        return new ResponseEntity<>(prix, HttpStatus.OK);
    }

}