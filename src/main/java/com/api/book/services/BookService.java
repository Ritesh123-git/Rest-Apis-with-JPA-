package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {
	
//	private static List<Book> list= new ArrayList<>();
//	static {
//	
//	list.add(new Book(12,"Java Complete reference","ben cutting"));
//	list.add(new Book(13,"Python complete","peter parker"));
//	list.add(new Book(14,"Think java","michael clarke"));
//	}
	
	
	@Autowired
	private BookRepository bookRepository;
	// get all books
	public List<Book> getAllBooks(){
	List<Book> list= (List<Book>) this.bookRepository.findAll();
	return list;
	}
	
	// get single book by id
	public Book getBookById(int id) {
		Book book=null;
//		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		
		try {
			book=this.bookRepository.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	// adding the book
	public Book addBook(Book b) {
		Book result=this.bookRepository.save(b);
		return result;
	}
	
	// delete the book
	public void deleteBook(int bid) {
		Book book=null;
//		book=list.stream().filter(e->e.getId()==bid).findFirst().get();
//		list.remove(book);
		
		bookRepository.deleteById(bid);
		
	}

	public void updateBook(Book book, int bookId) {
		
//		list=list.stream().map(b->{
//			
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bookId);
		bookRepository.save(book);
		
		// TODO Auto-generated method stub
		
	}
	

}
