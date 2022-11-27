package com.gemarminjem.service;

import com.gemarminjem.entity.JenisPinjaman;
import com.gemarminjem.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JenisPinjamanService implements IBaseService<JenisPinjaman> {
    @Autowired
    IBaseRepository<JenisPinjaman> jenisPinjamanIBaseRepository;

    @Override
    public void create(JenisPinjaman data) {
        jenisPinjamanIBaseRepository.create(data);
    }

    @Override
    public JenisPinjaman getById(int id) {
        return jenisPinjamanIBaseRepository.getById(id);
    }

    @Override
    public List<JenisPinjaman> getAll(int page, int pageSize) {
        return jenisPinjamanIBaseRepository.getAll(page, pageSize);
    }

    @Override
    public void update(int id, JenisPinjaman data) {
        jenisPinjamanIBaseRepository.update(id, data);
    }

    @Override
    public void delete(int id) {
        jenisPinjamanIBaseRepository.delete(id);
    }
}
