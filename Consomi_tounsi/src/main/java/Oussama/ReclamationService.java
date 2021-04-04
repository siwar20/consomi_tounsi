package Oussama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ReclamationService {
    @Autowired
    ReclamationRepository Pr;
    
    public List<reclamation> retrieveAllProducts() {
        return (List<reclamation>) Pr.findAll();
    }

    
    public Product addProduct(Product P) {
        return Pr.save(P);
    }

    
    public void deleteProduct(Long id) {
        Optional<Product> optionalProduct=Pr.findById(id);
        if (!optionalProduct.isPresent()) {
            throw new IllegalStateException("Product Not Found");
        }
        Pr.deleteById(id);

    }

    
    public void deleteProduct(String id) {


        Pr.deleteById(Long.parseLong(id));
    }

    
    public Product updateProduct(Product P) {
        return Pr.save(P);
    }

    
    public Optional<Product> FindProduct(Long id) {
      return   Pr.findById(id);
    }

   
    public Optional<Product> FindProduct(String id) {
      return  Pr.findById(Long.parseLong(id));
    }
