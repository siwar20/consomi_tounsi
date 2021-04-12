package tn.esprit.spring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entities.Eventse;
import Exception.ResourceNotFoundException;
import Repositories.EventRepository;

@RestController
public class EventController {
	@Autowired
	private EventRepository er ;


	@GetMapping("/Events")
	public List<Eventse> getAllEvents() {
		return er.findAll();
	}
	@GetMapping("/event/{id}")
	public ResponseEntity<Eventse> getEmployeeById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Eventse event = er.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + id));
		return ResponseEntity.ok().body(event);
	}
	@PostMapping("/saveEvent")
	public Eventse createEvent(@Validated @RequestBody Eventse event) {
		return er.save(event);
	}

}

