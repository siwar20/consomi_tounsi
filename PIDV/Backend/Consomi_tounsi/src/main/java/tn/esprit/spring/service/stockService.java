package tn.esprit.spring.service;

import java.util.List;
//import java.util.Optional;

import tn.esprit.spring.entity.OrderStock;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Stocks;

public interface stockService {
	
List<Stocks> retrieveAllStocks();
	
	Stocks addStocks(Stocks S);
	
	void deleteStocks(Long id);
	
	Stocks updateStocks(Stocks S);
	
	Stocks retrieveStocks(Long StocksId);
	
	Stocks PassOrderStock (OrderStock orderstock);
	
	Product affecterProductAStocks(Long ProId, Long StoId);
	
	
	
}
