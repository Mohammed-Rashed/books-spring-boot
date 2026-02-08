package com.rashed.books.repository;

import com.rashed.books.base.BaseRepository;
import com.rashed.books.entity.Auther;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutherRepo extends BaseRepository<Auther> {

}
