package com.gemarminjem.repository;

import com.gemarminjem.entity.Cabang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CabangRepository implements IBaseRepository<Cabang> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(Cabang data) {
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
    public Cabang getById(int id) {
        return entityManager.find(Cabang.class, id);
    }

    @Override
    public List<Cabang> getAll(int page, int pageSize) {
        String sql = "SELECT c FROM Cabang c ORDER BY c.cabangId";
        TypedQuery<Cabang> cabangTypedQuery = entityManager.createQuery(sql, Cabang.class);
        cabangTypedQuery.setFirstResult((page - 1) * pageSize);
        cabangTypedQuery.setMaxResults(pageSize);
        return cabangTypedQuery.getResultList();
    }

    @Override
    public void update(int id, Cabang data) {
        Cabang oldCabang = getById(id);

        if (data.getNamaCabang() != null) {
            oldCabang.setNamaCabang(data.getNamaCabang());
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(oldCabang);
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
            Cabang cabang = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(cabang);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
