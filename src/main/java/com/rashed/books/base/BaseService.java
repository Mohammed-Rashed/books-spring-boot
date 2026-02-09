package com.rashed.books.base;

import com.rashed.books.entity.Auther;
import jakarta.persistence.MappedSuperclass;

import java.util.List;

@MappedSuperclass
public abstract class BaseService<T extends BaseEntity> {

    protected final BaseRepository<T> baseRepository;

    protected BaseService(BaseRepository<T> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public T findById(Long id) {
        return baseRepository.findById(id).orElse(null);
    }
    public List<T> findAll() {
        return (List<T>) baseRepository.findAll();
    }
    public  T save(T entity) {
        return baseRepository.save(entity);
    }
    public  List<T> saveAll(List<T> entity) {
        return (List<T>) baseRepository.saveAll(entity);
    }
    public T update(T entity) {
        T existingT = baseRepository.findById(entity.getId()).orElse(null);
        return baseRepository.save(existingT);
    }
    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }
    public int updateStatus(Long id,String statusCode) {
       return baseRepository.updateStatus(id,statusCode);
    }

}
