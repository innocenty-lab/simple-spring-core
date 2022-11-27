package com.gemarminjem.repository;

import com.gemarminjem.entity.DetailPinjaman;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DetailPinjamanRepository implements IBaseRepository<DetailPinjaman> {
    @Autowired
    EntityManager entityManager;

    @Override
    public void create(DetailPinjaman data) {
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
    public DetailPinjaman getById(int id) {
        return entityManager.find(DetailPinjaman.class, id);
    }

    @Override
    public List<DetailPinjaman> getAll(int page, int pageSize) {
        String sql = "SELECT dp FROM DetailPinjaman dp ORDER BY dp.detailPinjamanId";
        TypedQuery<DetailPinjaman> detailPinjamanTypedQuery = entityManager.createQuery(sql, DetailPinjaman.class);
        detailPinjamanTypedQuery.setFirstResult((page - 1) * pageSize);
        detailPinjamanTypedQuery.setMaxResults(pageSize);
        return detailPinjamanTypedQuery.getResultList();
    }

    @Override
    public void update(int id, DetailPinjaman data) {
        DetailPinjaman oldDetailPinjaman = getById(id);

        if (data.getNasabahList() != null) {
            oldDetailPinjaman.setNasabahList(data.getNasabahList());
        }

        if (data.getProdukPinjaman() != null) {
            oldDetailPinjaman.setProdukPinjaman(data.getProdukPinjaman());
        }

        if (data.getIs_approved() != null) {
            oldDetailPinjaman.setIs_approved(data.getIs_approved());
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(oldDetailPinjaman);
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
            DetailPinjaman detailPinjaman = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(detailPinjaman);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
