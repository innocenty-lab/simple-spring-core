package com.gemarminjem.service;

import com.gemarminjem.entity.DetailPinjaman;
import com.gemarminjem.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DetailPinjamanService implements IBaseService<DetailPinjaman> {
    @Autowired
    IBaseRepository<DetailPinjaman> detailPinjamanIBaseRepository;

    @Override
    public void create(DetailPinjaman data) {
        detailPinjamanIBaseRepository.create(data);
    }

    @Override
    public DetailPinjaman getById(int id) {
        return detailPinjamanIBaseRepository.getById(id);
    }

    @Override
    public List<DetailPinjaman> getAll(int page, int pageSize) {
        return detailPinjamanIBaseRepository.getAll(page, pageSize);
    }

    @Override
    public void update(int id, DetailPinjaman data) {
        detailPinjamanIBaseRepository.update(id, data);
    }

    @Override
    public void delete(int id) {
        detailPinjamanIBaseRepository.delete(id);
    }
}
