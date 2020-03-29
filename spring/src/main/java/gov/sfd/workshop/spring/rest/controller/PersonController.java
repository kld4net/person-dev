package gov.sfd.workshop.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.sfd.workshop.spring.rest.model.Person;
import gov.sfd.workshop.spring.rest.service.PersonService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/")
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@GetMapping("/")
	public List<Person> getAll() {
		return personService.getAll();
	}
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable("id") Long id) throws NotFoundException {
		return personService.getPerson(id);
	}
	
	@PutMapping("/{id}")
	public Person upatePerson(@PathVariable("id") Long id , @RequestBody Person person) throws NotFoundException {
		return personService.updatePerson(person, id);
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable("id") Long id ) throws NotFoundException {
		System.out.println("yes");
		personService.deletedDto(id);
	}
}
