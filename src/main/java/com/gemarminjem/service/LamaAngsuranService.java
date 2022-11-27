package com.gemarminjem.service;

import com.gemarminjem.entity.LamaAngsuran;
import com.gemarminjem.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LamaAngsuranService implements IBaseService<LamaAngsuran> {
    @Autowired
    IBaseRepository<LamaAngsuran> lamaAngsuranIBaseRepository;

    @Override
    public void create(LamaAngsuran data) {
        lamaAngsuranIBaseRepository.create(data);
    }

    @Override
    public LamaAngsuran getById(int id) {
        return lamaAngsuranIBaseRepository.getById(id);
    }

    @Override
    public List<LamaAngsuran> getAll(int page, int pageSize) {
        return lamaAngsuranIBaseRepository.getAll(page, pageSize);
    }

    @Override
    public void update(int id, LamaAngsuran data) {
        lamaAngsuranIBaseRepository.update(id, data);
    }

    @Override
    public void delete(int id) {
        lamaAngsuranIBaseRepository.delete(id);
    }
}
