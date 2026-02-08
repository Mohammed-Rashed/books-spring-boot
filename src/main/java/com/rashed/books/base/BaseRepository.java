package com.rashed.books.base;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    @Modifying
    @Transactional
    @Query("update #{#entityName} e set e.statusCode = :statusCode where e.id = :id")
    void updateEntity(@Param("id") Long id,@Param("statusCode") String statusCode);
}
