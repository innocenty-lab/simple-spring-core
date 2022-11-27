package com.gemarminjem.repository;

import com.gemarminjem.entity.LamaAngsuran;
import com.gemarminjem.service.IBaseService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LamaAngsuranRepository implements IBaseRepository<LamaAngsuran> {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(LamaAngsuran data) {
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
    public LamaAngsuran getById(int id) {
        return entityManager.find(LamaAngsuran.class, id);
    }

    @Override
    public List<LamaAngsuran> getAll(int page, int pageSize) {
        String sql = "SELECT la FROM LamaAngsuran ls ORDER BY ls.lamaAngsuranId";
        TypedQuery<LamaAngsuran> lamaAngsuranTypedQuery = entityManager.createQuery(sql, LamaAngsuran.class);
        lamaAngsuranTypedQuery.setFirstResult((page - 1) * pageSize);
        lamaAngsuranTypedQuery.setMaxResults(pageSize);
        return lamaAngsuranTypedQuery.getResultList();
    }

    @Override
    public void update(int id, LamaAngsuran data) {
        LamaAngsuran oldLamaAngsuran = getById(id);

        if (data.getBulanAngsuran() != null) {
            oldLamaAngsuran.setBulanAngsuran(data.getBulanAngsuran());
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(oldLamaAngsuran);
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
            LamaAngsuran lamaAngsuran = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(lamaAngsuran);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
