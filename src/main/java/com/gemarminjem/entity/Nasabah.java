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

    @Column(nullable = false)
    @Setter @Getter
    private String alamat;

    @Column(nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private Boolean ktp = false;

    @Column(nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private Boolean kk = false;

    @Column(nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private Boolean bpkb = false;

    @Column(name = "surat_tanah", nullable = false, columnDefinition = "boolean default false")
    @Setter @Getter
    private Boolean suratTanah = false;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @Setter @Getter
    private Cabang cabang;
}
