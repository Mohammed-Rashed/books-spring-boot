package com.rashed.books.service;

import com.rashed.books.base.BaseRepository;
import com.rashed.books.base.BaseService;
import com.rashed.books.entity.Auther;
import com.rashed.books.entity.Book;
import com.rashed.books.repository.AutherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutherService extends BaseService<Auther> {

    protected AutherService(BaseRepository<Auther> baseRepository) {
        super(baseRepository);
    }

    @Override
    public Auther update(Auther auther) {
        Auther existingAuther = super.findById(auther.getId());
        existingAuther.setName(auther.getName());
        return super.save(existingAuther);
    }
}
