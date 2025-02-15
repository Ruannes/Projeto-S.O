package com.checkIN_checkOUT.demo.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "configuracao_chefe")
public class ConfiguracaoChefe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean permitirBancoHoras; //  Nova configuração

    @OneToOne(mappedBy = "configuracao")
    private Chefe chefe;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isPermitirBancoHoras() { return permitirBancoHoras; }
    public void setPermitirBancoHoras(boolean permitirBancoHoras) { this.permitirBancoHoras = permitirBancoHoras; }

    public Chefe getChefe() { return chefe; }
    public void setChefe(Chefe chefe) { this.chefe = chefe; }
}
