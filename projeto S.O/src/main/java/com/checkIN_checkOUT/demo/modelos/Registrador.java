package com.checkIN_checkOUT.demo.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "registrador")
public class Registrador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String localizacao;

    @ManyToOne
    @JoinColumn(name = "chefe_id")
    private Chefe chefe;

    @OneToMany(mappedBy = "registrador")
    private List<RegistroCheckinCheckout> registros;
}
