package edu.missouristate.noahgeren.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.missouristate.noahgeren.dao.BookRepository;
import edu.missouristate.noahgeren.domain.Book;

/**
 * 
 * @author noahgeren
 *
 * Service for CRUD operations on book domain entities.
 *
 * @see edu.missouristate.noahgeren.domain.Book
 * @see edu.missouristate.noahgeren.dao.BookRepository
 */
@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	/**
	 * Saves a book to the repository.
	 * @param book The book to be saved.
	 * @return True if saved, false if there was an error.
	 */
	public boolean save(Book book) {
		if(book == null) return false;
		return bookRepo.save(book) != null;
	}
	
	/**
	 * Gets a book from the repository based on the book's id.
	 * @param id The book id being searched for.
	 * @return The book related to the given id or null if none exist.
	 */
	public Book getBookById(Integer id) {
		if(id == null) return null;
		return bookRepo.findById(id).orElse(null);
	}
	
	/**
	 * Tries to delete a boo.
	 * @param id The id of the book trying to be deleted.
	 */
	public void delete(Integer id) {
		bookRepo.deleteById(id);
	}
	
	/**
	 * Gets a list of all books contained in the repository. 
	 * @return List of books in the repository.
	 */
	public List<Book> getAll(){
		return (List<Book>) bookRepo.findAll();
	}
	
}
