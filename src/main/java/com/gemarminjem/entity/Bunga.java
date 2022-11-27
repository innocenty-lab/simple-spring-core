package com.gemarminjem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class Bunga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bunga_id", nullable = false)
    @Setter @Getter
    private long bungaId;

    @Column(nullable = false)
    @Setter @Getter
    private Double pct;
}
