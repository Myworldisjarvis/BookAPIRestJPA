package com.restapi.book.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.book.entites.Book;



public interface BookRepository extends CrudRepository<Book,Integer> {

	public Book findById(int id);
	
}
