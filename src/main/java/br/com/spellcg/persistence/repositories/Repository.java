package br.com.spellcg.persistence.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

interface Repository<T> {
    T create(T entity);
    T findById(UUID id);
    T update(T entity);
    void delete(T entity);
    Page<T> findAll(Pageable pageable);
}
