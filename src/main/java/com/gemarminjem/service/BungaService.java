package com.gemarminjem.service;

import com.gemarminjem.entity.Bunga;
import com.gemarminjem.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BungaService implements IBaseService<Bunga> {
    @Autowired
    private IBaseRepository<Bunga> bungaIBaseRepository;

    @Override
    public void create(Bunga data) {
        bungaIBaseRepository.create(data);
    }

    @Override
    public Bunga getById(int id) {
        return bungaIBaseRepository.getById(id);
    }

    @Override
    public List<Bunga> getAll(int page, int pageSize) {
        return bungaIBaseRepository.getAll(page, pageSize);
    }

    @Override
    public void update(int id, Bunga data) {
        bungaIBaseRepository.update(id, data);
    }

    @Override
    public void delete(int id) {
        bungaIBaseRepository.delete(id);
    }
}
