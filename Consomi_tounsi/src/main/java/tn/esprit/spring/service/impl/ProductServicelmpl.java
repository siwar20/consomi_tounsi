package tn.esprit.spring.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Optional;
import java.util.Locale;

//import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.Stocks;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.service.ProductService;
import tn.esprit.spring.service.stockService;

@Service
public class ProductServicelmpl implements ProductService {

	@Autowired
	public ProductRepository Prodrep;

	@Autowired
	public stockService stockService;

	@Override
	public List<Product> retrieveAllProducts() {
		return (List<Product>) Prodrep.findAll();
	}

	@Override
	public Product addProduct(Product P) {
		return Prodrep.save(P);
	}

	@Override
	public void deleteProduct(Long id) {
		Prodrep.deleteById(id);
	}

	@Override
	public Product updateProduct(Product P) {
		return Prodrep.save(P);
	}

	@Override
	public Product retrieveProduct(Long idProduct) {

		return Prodrep.findProductByid(idProduct);
	}

	@Override
	public List<Product> findProductByNameAndType(String q, String t) {

		return Prodrep.findProductByProduct_nameAndProduct_type(q, t);
	}

	@Override
	public void verifierProductByDateExpiration(Product product) {
		Timestamp tsExp = new Timestamp(product.getDateExp());
		LocalDate dateExpiration = tsExp.toLocalDateTime().toLocalDate();
		LocalDate today = LocalDate.now();

		if(isExpired(today, dateExpiration)) {
			stockService.deleteStocks(product.getStocks().getId());
		} else {
			if(shouldBeAddedToPublicity(today, dateExpiration)) {
				//add product to publicity
			}
		}

	}

	private boolean isExpired(LocalDate today, LocalDate dateExpiration) {
		if (today.getYear() > dateExpiration.getYear()) {
			return true;
		} else if (today.getYear() == dateExpiration.getYear()) {
			if (today.getMonthValue() > dateExpiration.getMonthValue()) {
				return true;
			} else if (today.getMonthValue() == dateExpiration.getMonthValue()) {
				if (today.getDayOfMonth() >= dateExpiration.getDayOfMonth()) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean shouldBeAddedToPublicity(LocalDate today, LocalDate dateExpiration) {
		if (today.getYear() == dateExpiration.getYear()) {
			if ((today.getDayOfMonth() <= dateExpiration.getDayOfMonth())
					&& (dateExpiration.minusMonths(1).getMonthValue() == today.getMonthValue())) {
				return true;
			}
		}

		return false;
	}

}
