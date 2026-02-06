package com.rashed.books.service;

import com.rashed.books.entity.Auther;
import com.rashed.books.repository.AutherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutherService {
    @Autowired
    private AutherRepo autherRepo;

    public Auther findById(Long id) {
       return autherRepo.findById(id).orElse(null);
    }
    public List<Auther> findAll() {
         return (List<Auther>) autherRepo.findAll();
    }
    public  Auther save(Auther auther) {
        return autherRepo.save(auther);
    }
    public  List<Auther> saveAll(List<Auther> authers) {
        return (List<Auther>) autherRepo.saveAll(authers);
    }
    public Auther update(Auther auther) {
        Auther existingAuther = autherRepo.findById(auther.getId()).orElse(null);
        existingAuther.setName(auther.getName());
        return autherRepo.save(existingAuther);
    }
    public void deleteById(Long id) {
        autherRepo.deleteById(id);
    }
}
