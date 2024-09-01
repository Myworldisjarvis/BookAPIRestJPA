package com.restapi.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.restapi.book.entites.Book;

//@service best hai ya fir aap @component use kar sakte hai
@Service
public class BookService {

	private static List<Book> booklist = new ArrayList<>();

	static {
		booklist.add(new Book(2, "python", "patani"));
		booklist.add(new Book(3, "javascrip", "patani"));
	}

	// get all books
	public List<Book> getAllBooks() {
		return booklist;
	}

	// get book by id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = booklist.stream().filter(e -> e.getBookId() == id).findFirst().get();	
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		

		return book;
	}

	// ADD BOOK USING CLIENT
	public Book addBook(Book b) {
		booklist.add(b);

		return b;
	}

	// delete book by id
	public void deleteBook(int id) {

//		for (Book book : booklist) {
//			if(book.getBookId()==id) {
//				booklist.remove(book); 
//			}
//		}

		booklist = booklist.stream().filter(book -> book.getBookId() != id).collect(Collectors.toList());

	}

	// update book by id
	public void updateBook(Book b, int id) {

//		for (Book book : booklist) {
//			if(book.getBookId()==id) {
//				 // Update the book details
//				book.setBookId(b.getBookId());
//                book.setTitle(b.getTitle());
//                book.setAuthor(b.getAuthor());
//                return book;  // Return the updated book
//			}
//		}
//		return null;

		booklist = booklist.stream().map(book -> {

			if (book.getBookId() == id) {
				book.setBookId(b.getBookId());
				book.setTitle(b.getTitle());
				book.setAuthor(b.getAuthor());
				}
			return book;
		}).collect(Collectors.toList());

	}

}
