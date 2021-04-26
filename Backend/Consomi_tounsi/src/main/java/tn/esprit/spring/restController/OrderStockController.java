package tn.esprit.spring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import tn.esprit.spring.entity.OrderStock;

import tn.esprit.spring.service.OrderStockService;

@Controller
@RequestMapping("/api/orderstock")
public class OrderStockController {
	
	@Autowired
	public OrderStockService orderservice;
	
	
	@GetMapping("/Stocks")
    public ResponseEntity<List<OrderStock>>  getAllOrderStock()  {
		List<OrderStock> OS = orderservice.retrieveAllOrderStock();
		return new ResponseEntity<>( OS, HttpStatus.OK);
    }
	


    @PostMapping("/add")
    public ResponseEntity<OrderStock> addOrderStock(@RequestBody OrderStock  orderstock )  {
    	OrderStock OS= orderservice.addOrderStock(orderstock);
    	return new ResponseEntity<>( OS,  HttpStatus.CREATED);
    }
    
     
    @PutMapping("/update")
    public ResponseEntity<OrderStock> updateOrderStock(@RequestBody OrderStock orderstock) {
        if (orderstock.getId() != null) {
        	orderstock =  orderservice.updateOrderStock(orderstock);
           
       }
        return new ResponseEntity<>(orderstock, HttpStatus.OK);
        
   }

   
    @GetMapping("/Stock/{id}")
    public ResponseEntity<OrderStock> getOrderStock(@PathVariable Long id) {
    	OrderStock OS = orderservice.retrieveOrderStock(id);
    	return new ResponseEntity<>( OS, HttpStatus.OK);	
    }

 
    @DeleteMapping("/delete/{id}")
    public void deleteOrderStock(@PathVariable Long id) {
    	orderservice.deleteOrderStock(id);
    }
    
   
	

	
	
}
