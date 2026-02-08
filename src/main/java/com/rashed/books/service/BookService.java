package com.rashed.books.service;

import com.rashed.books.base.BaseRepository;
import com.rashed.books.base.BaseService;
import com.rashed.books.entity.Book;
import com.rashed.books.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService extends BaseService<Book> {


    protected BookService(BaseRepository<Book> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Book update(Book book) {
        Book existingBook = super.findById(book.getId());
        existingBook.setName(book.getName());
        existingBook.setPrice(book.getPrice());
        return super.save(existingBook);
    }

}
