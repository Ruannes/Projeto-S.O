package com.checkIN_checkOUT.demo.controlador;

import com.checkIN_checkOUT.demo.servico.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkIN_checkOUT.demo.modelos.*;

@RestController
@RequestMapping("/")
public class MainController {

    private final ChefeServico chefeServico;
    private FuncionarioServico funcionarioServico;
    private CheckinCheckoutServico checkinCheckoutServico;
    private ConfiguracaoServico configuracaoServico;
    private RegistradorServico registradorServico;

    public MainController(ChefeServico chefeServico, FuncionarioServico funcionarioServico, CheckinCheckoutServico checkinCheckoutServico, ConfiguracaoServico configuracaoServico, RegistradorServico registradorServico) {
        this.chefeServico = chefeServico;
        this.funcionarioServico = funcionarioServico;
        this.checkinCheckoutServico = checkinCheckoutServico;
        this.configuracaoServico = configuracaoServico;
        this.registradorServico = registradorServico;
    }

    public static void main(String[] args) {
        Chefe chefe = new Chefe();

    }

}
