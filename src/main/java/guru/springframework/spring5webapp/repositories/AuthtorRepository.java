package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.models.Author;

public interface AuthtorRepository extends CrudRepository<Author, Long> {

}
