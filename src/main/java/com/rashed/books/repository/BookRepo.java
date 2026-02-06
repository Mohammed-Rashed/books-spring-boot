package com.rashed.books.repository;

import com.rashed.books.entity.Auther;
import com.rashed.books.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends CrudRepository<Book,Long> {

    @Override
    @EntityGraph(attributePaths = {"auther"})
    List<Book> findAll();

    @Override
    @EntityGraph(attributePaths = {"auther"})
    Optional<Book> findById(Long id);

}
