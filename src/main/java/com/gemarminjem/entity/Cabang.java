package com.gemarminjem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Cabang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cabang_id", nullable = false)
    @Setter @Getter
    private long cabangId;

    @Column(name = "nama_cabang", nullable = false)
    @Setter @Getter
    private String namaCabang;
}
