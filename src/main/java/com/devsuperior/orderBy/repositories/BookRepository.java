package com.devsuperior.orderBy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.orderBy.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	public List<Book> findByOrderByName();
	
	public List<Book> findByOrderByAuthorAscPublicationDateDesc();

}
