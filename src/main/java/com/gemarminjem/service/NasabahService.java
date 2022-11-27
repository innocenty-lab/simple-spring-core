package com.gemarminjem.service;

import com.gemarminjem.entity.Nasabah;
import com.gemarminjem.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NasabahService implements IBaseService<Nasabah> {
    @Autowired
    IBaseRepository<Nasabah> nasabahIBaseRepository;

    @Override
    public void create(Nasabah data) {
        nasabahIBaseRepository.create(data);
    }

    @Override
    public Nasabah getById(int id) {
        return nasabahIBaseRepository.getById(id);
    }

    @Override
    public List<Nasabah> getAll(int page, int pageSize) {
        return nasabahIBaseRepository.getAll(page, pageSize);
    }

    @Override
    public void update(int id, Nasabah data) {
        nasabahIBaseRepository.update(id, data);
    }

    @Override
    public void delete(int id) {
        nasabahIBaseRepository.delete(id);
    }
}
