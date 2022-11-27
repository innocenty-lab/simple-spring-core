package com.gemarminjem.repository;

import com.gemarminjem.entity.LamaAngsuran;
import com.gemarminjem.entity.Nasabah;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NasabahRepository implements IBaseRepository<Nasabah> {
    @Autowired
    EntityManager entityManager;

    @Override
    public void create(Nasabah data) {
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
    public Nasabah getById(int id) {
        return entityManager.find(Nasabah.class, id);
    }

    @Override
    public List<Nasabah> getAll(int page, int pageSize) {
        String sql = "SELECT n FROM Nasabah n ORDER BY n.nasabahId";
        TypedQuery<Nasabah> nasabahTypedQuery = entityManager.createQuery(sql, Nasabah.class);
        nasabahTypedQuery.setFirstResult((page - 1) * pageSize);
        nasabahTypedQuery.setMaxResults(pageSize);
        return nasabahTypedQuery.getResultList();
    }

    @Override
    public void update(int id, Nasabah data) {
        Nasabah oldNasabah = getById(id);

        if (data.getNama() != null) {
            oldNasabah.setNama(data.getNama());
        }
        if (data.getAlamat() != null) {
            oldNasabah.setAlamat(data.getAlamat());
        }
        if (data.getKtp() != null) {
            oldNasabah.setKtp(data.getKtp());
        }
        if (data.getKk() != null) {
            oldNasabah.setKk(data.getKk());
        }
        if (data.getBpkb() != null) {
            oldNasabah.setBpkb(data.getBpkb());
        }
        if (data.getSuratTanah() != null) {
            oldNasabah.setSuratTanah(data.getSuratTanah());
        }
        if (data.getCabang() != null) {
            oldNasabah.setCabang(data.getCabang());
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(oldNasabah);
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
            Nasabah nasabah = getById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(nasabah);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
}
