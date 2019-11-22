package edu.missouristate.noahgeren.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.missouristate.noahgeren.domain.Book;

/**
 * 
 * @author noahgeren
 * 
 * Basic CRUD repository for the Book domain entity.
 * 
 * @see edu.missouristate.noahgeren.domain.Book
 *
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
