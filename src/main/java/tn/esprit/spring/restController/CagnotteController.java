package tn.esprit.spring.restController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entities.Cagnotte;
import Exception.ResourceNotFoundException;
import Repositories.CagnotteRepository;

 public class CagnotteController {
	@Autowired
	private CagnotteRepository dr ;
	@PostMapping("/saveDon")
	public Cagnotte createDon(@Validated @RequestBody Cagnotte don) {
		return dr.save(don);
}
	@GetMapping("/Cagnotte")
	public List<Cagnotte> getAllDons() {
		return dr.findAll();
	}
	@DeleteMapping("/deleteCagnotte/{id}")
	public Map<String, Boolean> deleteDon(@PathVariable(value = "id") Long idDon)
			throws ResourceNotFoundException {
		Cagnotte cag = dr.findById(idDon)
				.orElseThrow(() -> new ResourceNotFoundException("Don not found for this id :: " + idDon));

		dr.delete(cag);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@GetMapping("/EventDons/{idEvent}")
	public List<Cagnotte> GetEventById(@PathVariable(value = "idEvent") Long idEvent) {
		return dr.findByidEvent(idEvent);
	}
	@GetMapping("/EventSum")
	public double somme() {
		return dr.sommeDon();
	}
	@GetMapping("/EventSum/{idEvent}")
	public double sommeById(@PathVariable(value = "idEvent") Long idEvent) {
		return dr.sommeDonEvent(idEvent);
	}
	
}
