package com.checkIN_checkOUT.demo.modelos;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "configuracao_chefe")
public class ConfiguracaoChefe {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private BigDecimal valorPadraoHora;
    private Boolean permiteBancoHoras;

    @OneToOne(mappedBy = "configuracao")
    private Chefe chefe;

    public ConfiguracaoChefe() {
    }

    public ConfiguracaoChefe(String id, BigDecimal valorPadraoHora, Boolean permiteBancoHoras) {
        this.id = id;
        this.valorPadraoHora = valorPadraoHora;
        this.permiteBancoHoras = permiteBancoHoras;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Chefe getChefe() {
        return chefe;
    }

    public void setChefe(Chefe chefe) {
        this.chefe = chefe;
    }

    public Boolean getPermiteBancoHoras() {
        return permiteBancoHoras;
    }

    public void setPermiteBancoHoras(Boolean permiteBancoHoras) {
        this.permiteBancoHoras = permiteBancoHoras;
    }

    public BigDecimal getValorPadraoHora() {
        return valorPadraoHora;
    }

    public void setValorPadraoHora(BigDecimal valorPadraoHora) {
        this.valorPadraoHora = valorPadraoHora;
    }
}
