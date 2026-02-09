package com.rashed.books.config;

import com.rashed.books.entity.Auther;
import com.rashed.books.entity.Book;
import com.rashed.books.service.AutherService;
import com.rashed.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartupApp implements CommandLineRunner {

    @Autowired
    private AutherService autherService;
    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("StartupApp is running...");
        System.out.println("AutherService: " + autherService);
        System.out.println("BookService: " + bookService);


        if(autherService.findAll().isEmpty()) {
            Auther auther = new Auther();
            auther.setName("Rashed");

            Auther auther2 = new Auther();
            auther2.setName("Asser");
            autherService.saveAll(Arrays.asList(auther,auther2));

            Book book = new Book();
            book.setName("Spring Boot in Action");
            book.setPrice(29.99);
            book.setAuther(autherService.findById(1L));

            Book book2 = new Book();
            book2.setName("Java in Action");
            book2.setPrice(39.99);
            book2.setAuther(autherService.findById(2L));

            bookService.saveAll(Arrays.asList(book,book2));
        }

    }
}
