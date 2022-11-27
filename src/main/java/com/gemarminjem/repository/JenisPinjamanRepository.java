package com.gemarminjem.repository;

import com.gemarminjem.entity.JenisPinjaman;
import com.gemarminjem.entity.LamaAngsuran;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JenisPinjamanRepository implements IBaseRepository<JenisPinjaman> {
    @Autowired
    EntityManager entityManager;

    @Override
    public void create(JenisPinjaman data) {
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
    public JenisPinjaman getById(int id) {
        return entityManager.find(JenisPinjaman.class, id);
    }

    @Override
    public List<JenisPinjaman> getAll(int page, int pageSize) {
        String sql = "SELECT jp FROM JenisPinjaman jp ORDER BY jp.jenisPinjamanId";
        TypedQuery<JenisPinjaman> jenisPinjamanTypedQuery = entityManager.createQuery(sql, JenisPinjaman.class);
        jenisPinjamanTypedQuery.setFirstResult((page - 1) * pageSize);
        jenisPinjamanTypedQuery.setMaxResults(pageSize);
        return jenisPinjamanTypedQuery.getResultList();
    }

    @Override
    public void update(int id, JenisPinjaman data) {
        JenisPinjaman oldJenisPinjaman = getById(id);

        if (data.getNamaPinjaman() != null) {
            oldJenisPinjaman.setNamaPinjaman(data.getNamaPinjaman());
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(oldJenisPinjaman);
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
            JenisPinjaman jenisPinjaman = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(jenisPinjaman);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
