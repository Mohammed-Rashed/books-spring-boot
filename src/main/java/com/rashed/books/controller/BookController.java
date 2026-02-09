package com.rashed.books.controller;

import com.rashed.books.dto.BookDto;
import com.rashed.books.entity.Book;
import com.rashed.books.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping()
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(bookService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }
    @PostMapping()
    public  ResponseEntity<?> saveBook(@RequestBody @Valid List<BookDto> dtos) {
        List<Book> books = dtos.stream()
                .map(dto -> {
                    Book book = new Book();
                    book.setName(dto.getName());
                    book.setPrice(dto.getPrice());
                    book.setAuther(dto.getAuther());
                    return book;
                })
                .toList();


        return ResponseEntity.ok(bookService.saveAll(books));
    }
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody @Valid Book Book) {
        return ResponseEntity.ok(bookService.save(Book));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok(null);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestParam String status) {
        Book book = bookService.findById(id);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookService.updateStatus(book.getId(),status));
    }
}
