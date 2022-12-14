package com.devsuperior.orderBy.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.orderBy.entities.Book;
import com.devsuperior.orderBy.repositories.BookRepository;

@RestController
@RequestMapping(value = "/books")
public class BookResource {
	
	@Autowired
	private BookRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll(){
		List<Book> result = repository.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/sortByName")
	public ResponseEntity<List<Book>> findOrderByName(){
		List<Book> result = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/sortByAuthorAndDate")
	public ResponseEntity<List<Book>> findOrderByAuthorAndDate(){
		Sort sort = Sort.by(Sort.Order.asc("author"), Sort.Order.desc("publicationDate"));
		List<Book> result = repository.findAll(sort);
		return ResponseEntity.ok(result);
	}
}
