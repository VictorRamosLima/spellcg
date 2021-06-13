package br.com.spellcg.facades;

import java.util.List;
import java.util.UUID;

public interface Facade<T> {
    T create(T t);
    List<T> search(T t);
    T findById(UUID id);
    List<T> index(T t);
    T update(T t);
    void delete(UUID id);
}
