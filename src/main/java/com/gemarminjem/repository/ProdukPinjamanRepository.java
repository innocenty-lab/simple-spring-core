package com.gemarminjem.repository;

import com.gemarminjem.entity.ProdukPinjaman;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProdukPinjamanRepository implements IBaseRepository<ProdukPinjaman> {
    @Autowired
    EntityManager entityManager;

    @Override
    public void create(ProdukPinjaman data) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(data);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public ProdukPinjaman getById(int id) {
        return entityManager.find(ProdukPinjaman.class, id);
    }

    @Override
    public List<ProdukPinjaman> getAll(int page, int pageSize) {
        String sql = "SELECT djp FROM DetailJenisPinjaman djp ORDER BY djp.detailJenisPinjamanId";
        TypedQuery<ProdukPinjaman> detailJenisPinjamanTypedQuery = entityManager.createQuery(sql, ProdukPinjaman.class);
        detailJenisPinjamanTypedQuery.setFirstResult((page - 1) * pageSize);
        detailJenisPinjamanTypedQuery.setMaxResults(pageSize);
        return detailJenisPinjamanTypedQuery.getResultList();
    }

    @Override
    public void update(int id, ProdukPinjaman data) {
        ProdukPinjaman oldDetailJenisPinjaman = getById(id);

        if (data.getJenisPinjaman() != null) {
            oldDetailJenisPinjaman.setJenisPinjaman(data.getJenisPinjaman());
        }

        if (data.getLamaAngsuran() != null) {
            oldDetailJenisPinjaman.setLamaAngsuran(data.getLamaAngsuran());
        }

        if (data.getBunga() != null) {
            oldDetailJenisPinjaman.setBunga(data.getBunga());
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(oldDetailJenisPinjaman);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(int id) {
        try {
            ProdukPinjaman detailJenisPinjaman = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(detailJenisPinjaman);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
