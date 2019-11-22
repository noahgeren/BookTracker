package edu.missouristate.noahgeren.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.missouristate.noahgeren.domain.Book;
import edu.missouristate.noahgeren.services.BookService;

/**
 * 
 * @author noahgeren	
 *
 * Controller that handles all Book Tracker app endpoints.
 * 
 * @see edu.missouristate.noahgeren.domain.Book	
 *
 */
@Controller
public class BookController {
	
	@Autowired
	BookService bookService;

	/**
	 * The home page for users to see book records.
	 * @param model All books will be added to the model
	 * @return "index"
	 */
	@GetMapping("/home")
	String home(Model model) {
		model.addAttribute("books", bookService.getAll());
		return "index";
	}
	
	/**
	 * The form for creating a new book record.
	 * @return "edit"
	 */
	@GetMapping("/create")
	String create() {
		return "edit";
	}
	
	/**
	 * The action endpoint for creating a new book record.
	 * @param book The book to be created. Generated from user input.
	 * @return Redirect to /home
	 */
	@PostMapping("/create")
	String create(Book book) {
		bookService.save(book);
		return "redirect:/home";
	}
	
	/**
	 * The form for editing a book record.
	 * @param model The book being edited will be added to populate the form.
	 * @param id The book's id being edited.
	 * @return "edit"
	 */
	@GetMapping("/update/{id}")
	String edit(Model model, @PathVariable Integer id) {
		model.addAttribute("book", bookService.getBookById(id));
		return "edit";
	}
	
	/**
	 * The action endpoint for updating a book record.
	 * @param book The new book record.
	 * @param id The id of the book being updated.
	 * @return Redirect to /home
	 */
	@PostMapping("/update/{id}")
	String edit(Book book, @PathVariable Integer id) {
		book.setId(id);
		bookService.save(book);
		return "redirect:/home";
	}
	
	/**
	 * Deletes a book record.
	 * @param id The id of the book being deleted.
	 * @return Redirect to /home
	 */
	@GetMapping("/delete/{id}")
	String delete(@PathVariable Integer id) {
		bookService.delete(id);
		return "redirect:/home";
	}
	
}
