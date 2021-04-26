package tn.esprit.spring.service.impl;

import java.util.List;
//import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.OrderStock;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Stocks;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.StockRepository;
import tn.esprit.spring.service.stockService;
@Service
public class StockServicelmpl implements stockService {
	
@Autowired
	
	public StockRepository Stockrep;



@Autowired
public ProductRepository prorep;

	@Override
	public List<Stocks> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return Stockrep.findAll();
	}

	@Override
	public Stocks addStocks(Stocks S) {
		// TODO Auto-generated method stub
		return Stockrep.save(S);
	}

	@Override
	public void deleteStocks(Long id) {
		 Stockrep.deleteById(id);
		
	}

	@Override
	public Stocks updateStocks(Stocks S) {
		// TODO Auto-generated method stub
		return Stockrep.save(S);
	}



	@Override
	public Stocks retrieveStocks(Long StocksId) {
		
		return Stockrep.findStockByid(StocksId);
	}

	@Override
	public Stocks PassOrderStock(OrderStock orderstock) {
		Stocks stock = orderstock.getStocks();
		
			List<OrderStock> orders = stock.getOrderstocks();
			orders.add(orderstock);
			int RemainingQuantity = stock.getStock_remaining_quantity();
			RemainingQuantity = RemainingQuantity + orderstock.getQuantity();
			stock.setStock_remaining_quantity(RemainingQuantity);
			stock = Stockrep.save(stock);
			
		
		
		return  stock;
	}

	@Override
	public Product affecterProductAStocks(Long ProId, Long StoId) {
		Stocks St = Stockrep.findById(StoId).get();
		Product Pr = prorep.findById(ProId).get();
		Pr.setStocks(St);
		return prorep.save(Pr);
	
		
	}

}

	
	

	
	
	


