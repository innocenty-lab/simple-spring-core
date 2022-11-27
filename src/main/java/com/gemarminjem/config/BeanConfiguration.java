package com.gemarminjem.config;

import com.gemarminjem.entity.*;
import com.gemarminjem.repository.*;
import com.gemarminjem.service.*;
import com.gemarminjem.util.JpaUtil;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {
    @Bean
    public EntityManager getEntityManager() {
        return JpaUtil.getEntityManager();
    }

    @Bean
    public IBaseRepository<Cabang> getCabangRepo() {
        return new CabangRepository();
    }

    @Bean
    public IBaseService<Cabang> getCabangServ() {
        return new CabangService();
    }

    @Bean
    public IBaseRepository<Bunga> getBungaRepo() {
        return new BungaRepository();
    }

    @Bean
    public IBaseService<Bunga> getBungaServ() {
        return new BungaService();
    }

    @Bean
    public IBaseRepository<LamaAngsuran> getLamaAngsuranRepo() {
        return new LamaAngsuranRepository();
    }

    @Bean
    public IBaseService<LamaAngsuran> getLamaAngsuranServ() {
        return new LamaAngsuranService();
    }

    @Bean
    public IBaseRepository<JenisPinjaman> getJenisPinjamanRepo() {
        return new JenisPinjamanRepository();
    }


    @Bean
    public IBaseService<JenisPinjaman> getJenisPinjamanServ() {
        return new JenisPinjamanService();
    }

    @Bean
    public IBaseRepository<ProdukPinjaman> getProdukPinjamanRepo() {
        return new ProdukPinjamanRepository();
    }

    @Bean
    public IBaseService<ProdukPinjaman> getProdukPinjamanServ() {
        return new ProdukPinjamanService();
    }

    @Bean IBaseRepository<DetailPinjaman> getDetailPinjamanRepo() {
        return new DetailPinjamanRepository();
    }

    @Bean IBaseService<DetailPinjaman> getDetailPinjamanServ() {
        return new DetailPinjamanService();
    }

    @Bean
    public IBaseRepository<Nasabah> getNasabahRepo() {
        return new NasabahRepository();
    }

    @Bean IBaseService<Nasabah> getNasabahServ() {
        return new NasabahService();
    }

    @Bean
    @Scope("prototype")
    JenisPinjaman getJenisPinjamanObj() {
        return new JenisPinjaman();
    }

    @Bean
    @Scope("prototype")
    LamaAngsuran getLamaAngsuranObj() {
        return new LamaAngsuran();
    }

    @Bean
    @Scope("prototype")
    Bunga getBungaObj() {
        return new Bunga();
    }

    @Bean
    @Scope("prototype")
    Cabang getCabangObj() {
        return new Cabang();
    }

    @Bean
    @Scope("prototype")
    ProdukPinjaman getDetailJenisPinjamanObj() {
        return new ProdukPinjaman();
    }

    @Bean
    @Scope("prototype")
    DetailPinjaman getDetailPinjamanObj() {
        return new DetailPinjaman();
    }

    @Bean
    @Scope("prototype")
    Nasabah getNasabahObj() {
        return new Nasabah();
    }
}
