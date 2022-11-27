package com.gemarminjem.service;

import com.gemarminjem.entity.ProdukPinjaman;
import com.gemarminjem.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProdukPinjamanService implements IBaseService<ProdukPinjaman> {
    @Autowired
    IBaseRepository<ProdukPinjaman> detailJenisPinjamanIBaseRepository;

    @Override
    public void create(ProdukPinjaman data) {
        detailJenisPinjamanIBaseRepository.create(data);
    }

    @Override
    public ProdukPinjaman getById(int id) {
        return detailJenisPinjamanIBaseRepository.getById(id);
    }

    @Override
    public List<ProdukPinjaman> getAll(int page, int pageSize) {
        return detailJenisPinjamanIBaseRepository.getAll(page, pageSize);
    }

    @Override
    public void update(int id, ProdukPinjaman data) {
        detailJenisPinjamanIBaseRepository.update(id, data);
    }

    @Override
    public void delete(int id) {
        detailJenisPinjamanIBaseRepository.delete(id);
    }
}
