package gov.sfd.workshop.spring.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.sfd.workshop.spring.rest.model.Person;
import gov.sfd.workshop.spring.rest.repository.PersonRepo;
import javassist.NotFoundException;
@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;
	
	public Person addPerson(Person person){
		System.out.println("add");
		return personRepo.save(person);
	}
	
	public Person updatePerson(Person person, Long id) throws NotFoundException{
		Person personObj = personRepo.findById(id).orElseThrow(() ->  new NotFoundException("Person not found"));
		

		personObj.setPersonFirstName(person.getPersonFirstName());
		personObj.setPersonSecondName(person.getPersonSecondName());
		personObj.setPersonThirdName(person.getPersonThirdName());
		personObj.setPersonFamilyName(person.getPersonFamilyName());
		personObj.setPersonSex(person.getPersonSex());
		personObj.setPersonStatus(person.getPersonStatus());
		personObj.setPersonBirthdate(person.getPersonBirthdate());
		personObj.setPersonIdType(person.getPersonIdType());
		personObj.setPersonIdNo(person.getPersonIdNo());
		personObj.setPersonMobile(person.getPersonMobile());
		personObj.setPersonEmail(person.getPersonEmail());
		personObj.setPersonAddress(person.getPersonAddress());

		
		return personRepo.save(personObj);
	}
	
	public void deletedDto(Long id) throws NotFoundException {
		System.out.println("delete");
		Person personObj = personRepo.findById(id).orElseThrow(() ->  new NotFoundException("Person not found"));
		personRepo.delete(personObj);
	}
	
	public Person getPerson(Long id) throws NotFoundException {
		return personRepo.findById(id).orElseThrow(() ->  new NotFoundException("Person not found"));
	}
	
	public List<Person> getAll(){
		return personRepo.findAll();
	}
}
