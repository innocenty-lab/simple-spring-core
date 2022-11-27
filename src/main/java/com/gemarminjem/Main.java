package com.gemarminjem;

import com.gemarminjem.config.BeanConfiguration;
import com.gemarminjem.entity.*;
import com.gemarminjem.service.*;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanConfiguration.class);
        ctx.refresh();

        EntityManager entityManager = ctx.getBean(EntityManager.class);

        IBaseService<Cabang> cabangIBaseService = ctx.getBean(CabangService.class);
        IBaseService<Bunga> bungaIBaseService = ctx.getBean(BungaService.class);
        IBaseService<LamaAngsuran> lamaAngsuranIBaseService = ctx.getBean(LamaAngsuranService.class);
        IBaseService<JenisPinjaman> jenisPinjamanIBaseService = ctx.getBean(JenisPinjamanService.class);
        IBaseService<ProdukPinjaman> produkPinjamanIBaseService = ctx.getBean(ProdukPinjamanService.class);
        IBaseService<DetailPinjaman> detailPinjamanIBaseService = ctx.getBean(DetailPinjamanService.class);
        IBaseService<Nasabah> nasabahIBaseService = ctx.getBean(NasabahService.class);

        JenisPinjaman jenisPinjaman1 = ctx.getBean(JenisPinjaman.class);
        JenisPinjaman jenisPinjaman2 = ctx.getBean(JenisPinjaman.class);
        LamaAngsuran lamaAngsuran1 = ctx.getBean(LamaAngsuran.class);
        LamaAngsuran lamaAngsuran2 = ctx.getBean(LamaAngsuran.class);
        LamaAngsuran lamaAngsuran3 = ctx.getBean(LamaAngsuran.class);
        LamaAngsuran lamaAngsuran4 = ctx.getBean(LamaAngsuran.class);
        LamaAngsuran lamaAngsuran5 = ctx.getBean(LamaAngsuran.class);
        Bunga bunga1 = ctx.getBean(Bunga.class);
        Bunga bunga2 = ctx.getBean(Bunga.class);
        ProdukPinjaman produkPinjaman1 = ctx.getBean(ProdukPinjaman.class);
        ProdukPinjaman produkPinjaman2 = ctx.getBean(ProdukPinjaman.class);
        ProdukPinjaman produkPinjaman3 = ctx.getBean(ProdukPinjaman.class);
        ProdukPinjaman produkPinjaman4 = ctx.getBean(ProdukPinjaman.class);
        ProdukPinjaman produkPinjaman5 = ctx.getBean(ProdukPinjaman.class);
        ProdukPinjaman produkPinjaman6 = ctx.getBean(ProdukPinjaman.class);
        ProdukPinjaman produkPinjaman7 = ctx.getBean(ProdukPinjaman.class);
        Cabang cabang1 = ctx.getBean(Cabang.class);
        Cabang cabang2 = ctx.getBean(Cabang.class);
        Cabang cabang3 = ctx.getBean(Cabang.class);
        DetailPinjaman detailPinjaman = ctx.getBean(DetailPinjaman.class);
        Nasabah nasabah = ctx.getBean(Nasabah.class);

//        // CREATE JENIS PINJAMAN
//        jenisPinjaman1.setNamaPinjaman("Agunan");
//        jenisPinjamanIBaseService.create(jenisPinjaman1);
//        jenisPinjaman2.setNamaPinjaman("Tanpa Agunan");
//        jenisPinjamanIBaseService.create(jenisPinjaman2);
//
//        // CREATE LAMA ANGSURAN
//        lamaAngsuran1.setBulanAngsuran(3);
//        lamaAngsuranIBaseService.create(lamaAngsuran1);
//        lamaAngsuran2.setBulanAngsuran(6);
//        lamaAngsuranIBaseService.create(lamaAngsuran2);
//        lamaAngsuran3.setBulanAngsuran(12);
//        lamaAngsuranIBaseService.create(lamaAngsuran3);
//        lamaAngsuran4.setBulanAngsuran(18);
//        lamaAngsuranIBaseService.create(lamaAngsuran4);
//        lamaAngsuran5.setBulanAngsuran(24);
//        lamaAngsuranIBaseService.create(lamaAngsuran5);
//
//        // CREATE BUNGA
//        bunga1.setPct(1.0);
//        bungaIBaseService.create(bunga1);
//        bunga2.setPct(1.5);
//        bungaIBaseService.create(bunga2);
//
//        // CREATE PRODUK PINJAMAN
//        // TANPA AGUNAN
//        produkPinjaman1.setJenisPinjaman(jenisPinjamanIBaseService.getById(2));
//        produkPinjaman1.setLamaAngsuran(lamaAngsuranIBaseService.getById(1));
//        produkPinjaman1.setBunga(bungaIBaseService.getById(2));
//        produkPinjamanIBaseService.create(produkPinjaman1);
//
//        produkPinjaman2.setJenisPinjaman(jenisPinjamanIBaseService.getById(2));
//        produkPinjaman2.setLamaAngsuran(lamaAngsuranIBaseService.getById(2));
//        produkPinjaman2.setBunga(bungaIBaseService.getById(2));
//        produkPinjamanIBaseService.create(produkPinjaman2);
//
//        produkPinjaman3.setJenisPinjaman(jenisPinjamanIBaseService.getById(2));
//        produkPinjaman3.setLamaAngsuran(lamaAngsuranIBaseService.getById(3));
//        produkPinjaman3.setBunga(bungaIBaseService.getById(2));
//        produkPinjamanIBaseService.create(produkPinjaman3);
//
//        produkPinjaman4.setJenisPinjaman(jenisPinjamanIBaseService.getById(2));
//        produkPinjaman4.setLamaAngsuran(lamaAngsuranIBaseService.getById(4));
//        produkPinjaman4.setBunga(bungaIBaseService.getById(2));
//        produkPinjamanIBaseService.create(produkPinjaman4);
//
//        // AGUNAN
//        produkPinjaman5.setJenisPinjaman(jenisPinjamanIBaseService.getById(1));
//        produkPinjaman5.setLamaAngsuran(lamaAngsuranIBaseService.getById(2));
//        produkPinjaman5.setBunga(bungaIBaseService.getById(1));
//        produkPinjamanIBaseService.create(produkPinjaman5);
//
//        produkPinjaman6.setJenisPinjaman(jenisPinjamanIBaseService.getById(1));
//        produkPinjaman6.setLamaAngsuran(lamaAngsuranIBaseService.getById(3));
//        produkPinjaman6.setBunga(bungaIBaseService.getById(1));
//        produkPinjamanIBaseService.create(produkPinjaman6);
//
//        produkPinjaman7.setJenisPinjaman(jenisPinjamanIBaseService.getById(1));
//        produkPinjaman7.setLamaAngsuran(lamaAngsuranIBaseService.getById(4));
//        produkPinjaman7.setBunga(bungaIBaseService.getById(1));
//        produkPinjamanIBaseService.create(produkPinjaman7);
//
//        // CREATE CABANG
//        cabang1.setNamaCabang("Jakarta Bank");
//        cabangIBaseService.create(cabang1);
//        cabang2.setNamaCabang("Bandung Bank");
//        cabangIBaseService.create(cabang2);
//        cabang3.setNamaCabang("Bekasi Bank");
//        cabangIBaseService.create(cabang3);

        // PENDAFTARAN NASABAH DAN MEMINJAM DILAKUKAN BERSAMAAN
        // CREATE NASABAH
        nasabah.setNama("Jos Sena");
        nasabah.setAlamat("Jakarta");
        nasabah.setKtp(true);
        nasabah.setKk(true);
        nasabah.setCabang(cabangIBaseService.getById(1));
        entityManager.contains(nasabah);

        // CREATE DETAIL PINJAMAN
//        detailPinjaman.setNasabah(nasabahIBaseService.getById(1));
        detailPinjaman.setNasabah(nasabah);
        detailPinjaman.setProdukPinjaman(produkPinjamanIBaseService.getById(2));
        detailPinjaman.setJumlahPinjaman(10000000);
        detailPinjaman.setIs_approved(false);
        detailPinjamanIBaseService.create(detailPinjaman);
    }
}