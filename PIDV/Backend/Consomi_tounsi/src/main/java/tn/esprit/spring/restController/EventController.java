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


import Exception.ResourceNotFoundException;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.repository.EventRepository;


@RestController
public class EventController {
	@Autowired
	private EventRepository er ;


	@GetMapping("/Events")
	public List<Event> getAllEvents() {
		return er.findAll();
	}
	@GetMapping("/event/{id}")
	public ResponseEntity<Event> getEmployeeById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Event event = er.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + id));
		return ResponseEntity.ok().body(event);
	}
	@PostMapping("/saveEvent")
	public Event createEvent(@Validated @RequestBody Event event) {
		return er.save(event);
	}

}

