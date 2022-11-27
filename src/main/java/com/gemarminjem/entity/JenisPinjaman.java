package com.gemarminjem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "JENIS_PINJAMAN")
@ToString
public class JenisPinjaman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jenis_pinjaman_id", nullable = false)
    @Setter @Getter
    private long jenisPinjamanId;

    @Column(name = "nama_pinjaman", nullable = false)
    @Setter @Getter
    private String namaPinjaman;
}
