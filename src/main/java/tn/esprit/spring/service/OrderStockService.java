package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.OrderStock;


public interface OrderStockService {
	
	List<OrderStock> retrieveAllOrderStock();
	
	OrderStock addOrderStock(OrderStock OS);
	
	void deleteOrderStock(Long id);
	
	OrderStock updateOrderStock(OrderStock OS);
	
	OrderStock retrieveOrderStock(Long idOrderStock);
	
	
}
