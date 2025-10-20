package com.example.cadastro_peixe.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name="peixe")
@Entity

public class Peixe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "especie", unique = true)
    private String especie;

    @Column(name = "quantidade_unidades", unique = true)
    private Double quantidade_unidades;

    @Column(name = "tanque_id")
    private String tanque_id;

    @Column(name = "observacoes", unique = true)
    private String observacoes;

}
