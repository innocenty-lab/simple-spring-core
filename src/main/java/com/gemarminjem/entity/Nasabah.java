package com.gemarminjem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Nasabah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nasabah_id", nullable = false)
    @Setter @Getter
    private long nasabahId;

    @Column(nullable = false)
    @Setter @Getter
    private String nama;

    @Column(nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private String alamat;

    @Column(nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private Boolean ktp;

    @Column(nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private Boolean kk;

    @Column(nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private Boolean bpkb;

    @Column(name = "surat_tanah", nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private Boolean suratTanah;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @Setter @Getter
    private Cabang cabang;
}
