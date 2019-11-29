package edu.missouristate.noahgeren.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 
 * @author noahgeren
 * 
 * The domain entity representing a book record.
 * Fields include:
 * <ul>
 * 		<li>Id</li>
 * 		<li>Title</li>
 * 		<li>Author</li>
 * 		<li>Date Read</li>
 * 		<li>If Finished</li>
 * </ul>
 * 
 * @see edu.missouristate.noahgeren.dao.BookRepository
 * @see edu.missouristate.noahgeren.controllers.BookController
 * @see edu.missouristate.noahgeren.services.BookService
 *
 */
@Entity
@Table(name = "BOOKS")
@Data
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String author;
	
	private Date dateRead;
	
	private Boolean finished;
	
	private String image;
	
	/**
	 * Checks if finished is not null and true. Sets finished to false if null.
	 * @return True if finished is true. False if finished is false or null.
	 */
	public Boolean getFinished() {
		return (finished != null) ? finished : (finished = false);
	}
	
}
