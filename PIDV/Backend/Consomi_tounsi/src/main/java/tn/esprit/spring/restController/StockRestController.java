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
//import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.OrderStock;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Stocks;
import tn.esprit.spring.service.stockService;

@Controller
@RequestMapping("/api/stock")
public class StockRestController {
	@Autowired
	public stockService stockService;

	
	@GetMapping("/Stocks")
    public ResponseEntity<List<Stocks>>  getAllStocks()  {
		List<Stocks> S = stockService.retrieveAllStocks();
		return new ResponseEntity<>( S, HttpStatus.OK);
    }
	


    @PostMapping("/add")
    public ResponseEntity<Stocks> addStocks(@RequestBody Stocks  stocks )  {
    	Stocks S= stockService.addStocks(stocks);
    	return new ResponseEntity<>( S,  HttpStatus.CREATED);
    }
    
     
    @PutMapping("/update")
    public ResponseEntity<Stocks> updateStocks(@RequestBody Stocks Stocks) {
         if (Stocks.getId() != null) {
        	 Stocks = stockService.updateStocks(Stocks);
        }
         return new ResponseEntity<>(Stocks, HttpStatus.OK);  
    }

   
    @GetMapping("/Stock/{id}")
    public ResponseEntity<Stocks> getStock(@PathVariable Long id) {
    	Stocks S = stockService.retrieveStocks(id);
    	return new ResponseEntity<>( S, HttpStatus.OK);	
    }

 
    @DeleteMapping("/Stock/{id}")
    public void deleteStocks(@PathVariable Long id) {
    	stockService.deleteStocks(id);
    }
	
   @PostMapping("/Stock/pass/{id}")
    public ResponseEntity<Stocks>  PassOrderStock(@RequestBody OrderStock orderstock, @PathVariable ("id") long id)
    {
	   
    	Stocks stock = stockService.retrieveStocks(id) ;
    	orderstock.setStocks(stock);
    	return new ResponseEntity<>(stockService.PassOrderStock(orderstock), HttpStatus.OK);
    	
		
    	
    }
   
    @PutMapping("/ProASto/{ProId}/{StoId}")
    public ResponseEntity<Product> affecterProductAStocks(@PathVariable ("ProId") Long ProId,@PathVariable("StoId") Long StoId ){
    Product product = 	stockService.affecterProductAStocks(ProId, StoId);
    	return new ResponseEntity<>(product, HttpStatus.OK);
    }
    

}
