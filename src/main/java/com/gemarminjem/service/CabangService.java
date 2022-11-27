package com.gemarminjem.service;

import com.gemarminjem.entity.Cabang;
import com.gemarminjem.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CabangService implements IBaseService<Cabang> {
    @Autowired
    IBaseRepository<Cabang> cabangIBaseRepository;

    @Override
    public void create(Cabang data) {
        cabangIBaseRepository.create(data);
    }

    @Override
    public Cabang getById(int id) {
        return cabangIBaseRepository.getById(id);
    }

    @Override
    public List<Cabang> getAll(int page, int pageSize) {
        return cabangIBaseRepository.getAll(page, pageSize);
    }

    @Override
    public void update(int id, Cabang data) {
        cabangIBaseRepository.update(id, data);
    }

    @Override
    public void delete(int id) {
        cabangIBaseRepository.delete(id);
    }
}
