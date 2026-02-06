package com.rashed.books.service;

import com.rashed.books.entity.Book;
import com.rashed.books.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Book findById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    public List<Book> findAll() {
        return (List<Book>) bookRepo.findAll();
    }
    public  Book save(Book Book) {
        return  bookRepo.save(Book);
    }
    public  List<Book> saveAll(List<Book> Book) {
        return (List<Book>) bookRepo.saveAll(Book);
    }
    public Book update(Book book) {
        Book existingBook = bookRepo.findById(book.getId()).orElse(null);
        existingBook.setName(book.getName());
        existingBook.setPrice(book.getPrice());
        return bookRepo.save(existingBook);
    }
    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }
}
