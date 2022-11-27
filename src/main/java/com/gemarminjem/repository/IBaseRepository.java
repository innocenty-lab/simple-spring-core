package com.gemarminjem.repository;

import java.util.List;

public interface IBaseRepository<T> {
    void create(T data);
    T getById(int id);
    List<T> getAll(int page, int pageSize);
    void update(int id, T data);
    void delete(int id);
}
