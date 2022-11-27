package com.gemarminjem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "PRODUK_PINJAMAN")
@ToString
public class ProdukPinjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produk_pinjaman_id", nullable = false)
    @Setter @Getter
    private long produkPinjamanId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jenis_pinjaman_id", nullable = false)
    @Setter @Getter
    private JenisPinjaman jenisPinjaman;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lama_angsuran_id", nullable = false)
    @Setter @Getter
    private LamaAngsuran lamaAngsuran;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bunga_id", nullable = false)
    @Setter @Getter
    private Bunga bunga;
}
