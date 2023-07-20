package com.spring.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(/book)
public class BookAPI {
	@Autowired
	private BookService booksevice;
	
	@GetMapping
	public List<Books> findAllBooks(){
		return bookService.findAllBooks();
	}
	@GetMapping("/{bookId}")
	public Book findBook (@PathVariable Long BookId) {
		return bookService.findBookById(bookId);
	}
	@PostMapping
	public Book createBook (@RequestBody Book book) {
		return bookService.createBook(book);
	}
	@DeleteMapping("/{bookId}")
	public void deleteBook (@PathVariable Long bookId) {
		bookService.deleteBook(bookId);
	}
	@PutMapping("/{bookId")
	public Book updateBook(
			@RequestBody Map<String, Stirng>update,
			@PathVariable Long bookId) {
		return bookService.updateBook(update, bookId);
	}

}
