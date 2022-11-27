package com.gemarminjem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "DETAIL_PINJAMAN")
@ToString
public class DetailPinjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_pinjaman_id", nullable = false)
    @Setter @Getter
    private long detailPinjamanId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nasabah_id", nullable = false)
    @Setter @Getter
    private Nasabah nasabahList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produk_pinjaman_id", nullable = false)
    @Setter @Getter
    private ProdukPinjaman produkPinjaman;

    @Column(name = "jumlah_pinjaman", nullable = false)
    private Integer jumlahPinjaman;

    @Column(name = "is_approved", nullable = false)
    @Setter @Getter
    private Boolean is_approved;
}
