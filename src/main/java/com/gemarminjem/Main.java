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

        Cabang cabang = ctx.getBean(Cabang.class);
        Bunga bunga = ctx.getBean(Bunga.class);
        LamaAngsuran lamaAngsuran = ctx.getBean(LamaAngsuran.class);
        JenisPinjaman jenisPinjaman = ctx.getBean(JenisPinjaman.class);
        ProdukPinjaman produkPinjaman = ctx.getBean(ProdukPinjaman.class);
        DetailPinjaman detailPinjaman = ctx.getBean(DetailPinjaman.class);
        Nasabah nasabah = ctx.getBean(Nasabah.class);

        cabang.setNamaCabang("Jakarta Bank");
        cabangIBaseService.create(cabang);

//        bunga.setPct(2.5);
//        bungaIBaseService.create(bunga);

//        jenisPinjaman.setNamaPinjaman("Agunan");

    }
}