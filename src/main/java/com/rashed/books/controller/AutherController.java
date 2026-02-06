package com.rashed.books.controller;

import com.rashed.books.entity.Auther;
import com.rashed.books.repository.AutherRepo;
import com.rashed.books.service.AutherService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authers")
public class AutherController {
    private AutherService autherService;

    public AutherController(AutherService autherService) {
        this.autherService = autherService;
    }
    @GetMapping()
    public ResponseEntity<?> getAllAuthers() {
        return ResponseEntity.ok(autherService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAutherById(@PathVariable Long id) {
        return ResponseEntity.ok(autherService.findById(id));
    }
    @PostMapping()
    public  ResponseEntity<?> saveAuther(@RequestBody List<Auther> auther) {
        return ResponseEntity.ok(autherService.saveAll(auther));
    }
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Auther auther) {
        return ResponseEntity.ok(autherService.save(auther));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAutherById(@PathVariable Long id) {
        autherService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
