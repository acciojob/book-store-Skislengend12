package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") String id){
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @GetMapping("get-all-books")
    public ResponseEntity<List<Book>> findAll(){
        List<Book> temp = bookService.findAllBooks();
        return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
    }

    @GetMapping("get-books-by-author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathParam("author") String author){
        List<Book> books = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }

    @GetMapping("get-books-by-genre")
    public ResponseEntity<List<Book>> findBooksByGenre(@PathParam("genre") String genre){
        List<Book> books = bookService.findBooksByAuthor(genre);
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("Book removed successfully", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete-all-books")
    public ResponseEntity<String> deleteAll(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("All books deleted successfully", HttpStatus.ACCEPTED);
    }

}
