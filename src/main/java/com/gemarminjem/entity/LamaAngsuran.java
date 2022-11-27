package com.gemarminjem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LAMA_ANGSURAN")
@ToString
public class LamaAngsuran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lama_angsuran", nullable = false)
    @Setter @Getter
    private long lamaAngsuranId;

    @Column(name = "bulan_angsuran", nullable = false)
    @Setter @Getter
    private String bulanAngsuran;
}
