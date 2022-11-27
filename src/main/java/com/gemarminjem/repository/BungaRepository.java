package com.gemarminjem.repository;

import com.gemarminjem.entity.Bunga;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BungaRepository implements IBaseRepository<Bunga> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(Bunga data) {
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
    public Bunga getById(int id) {
        return entityManager.find(Bunga.class, id);
    }

    @Override
    public List<Bunga> getAll(int page, int pageSize) {
        String sql = "SELECT b FROM Bunga b ORDER BY b.bungaId";
        TypedQuery<Bunga> bungaTypedQuery = entityManager.createQuery(sql, Bunga.class);
        bungaTypedQuery.setFirstResult((page - 1) * pageSize);
        bungaTypedQuery.setMaxResults(pageSize);
        return bungaTypedQuery.getResultList();
    }

    @Override
    public void update(int id, Bunga data) {
        Bunga oldBunga = getById(id);

        if (data.getPct() != null) {
            oldBunga.setPct(data.getPct());
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(oldBunga);
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
            Bunga bunga = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(bunga);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
