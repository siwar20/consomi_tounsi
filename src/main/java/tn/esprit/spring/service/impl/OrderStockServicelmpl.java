package tn.esprit.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.OrderStock;
import tn.esprit.spring.repository.OrderStockRepository;
import tn.esprit.spring.service.OrderStockService;

@Service
public class OrderStockServicelmpl implements OrderStockService{

	
	@Autowired
	public OrderStockRepository orderstockrepo;

	@Override
	public List<OrderStock> retrieveAllOrderStock() {
		return (List<OrderStock>) orderstockrepo.findAll();
	}

	@Override
	public OrderStock addOrderStock(OrderStock OS) {
		return orderstockrepo.save(OS);
	}

	@Override
	public void deleteOrderStock(Long id) {
		orderstockrepo.deleteById(id);
	}

	@Override
	public OrderStock updateOrderStock(OrderStock OS) {
		return orderstockrepo.save(OS);
	}

	@Override
	public OrderStock retrieveOrderStock(Long idOrderStock) {
		return orderstockrepo.findOrderStockByid(idOrderStock);
	}

	
	
	
	
}
