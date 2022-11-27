package com.gemarminjem.service;

import java.util.List;

public interface IBaseService<T> {
    void create(T data);
    T getById(int id);
    List<T> getAll(int page, int pageSize);
    void update(int id, T data);
    void delete(int id);
}
