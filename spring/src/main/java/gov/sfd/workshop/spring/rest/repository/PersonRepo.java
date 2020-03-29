package gov.sfd.workshop.spring.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.sfd.workshop.spring.rest.model.Person;

public interface PersonRepo extends JpaRepository<Person, Long> {

}
