package com.checkIN_checkOUT.demo.modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "registro_checkin_checkout")
public class RegistroCheckinCheckout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;

    @ManyToOne
    @JoinColumn(name = "registrador_id")
    private Registrador registrador;
}

