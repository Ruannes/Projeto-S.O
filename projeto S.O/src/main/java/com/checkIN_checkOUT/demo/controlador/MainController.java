package com.checkIN_checkOUT.demo.controlador;

import com.checkIN_checkOUT.demo.servico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.checkIN_checkOUT.demo.modelos.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

    private final ChefeServico chefeServico;
    private FuncionarioServico funcionarioServico;
    private CheckinCheckoutServico checkinCheckoutServico;
    private ConfiguracaoServico configuracaoServico;
    private RegistradorServico registradorServico;

    @Autowired
    public MainController(ChefeServico chefeServico, FuncionarioServico funcionarioServico, CheckinCheckoutServico checkinCheckoutServico, ConfiguracaoServico configuracaoServico, RegistradorServico registradorServico) {
        this.chefeServico = chefeServico;
        this.funcionarioServico = funcionarioServico;
        this.checkinCheckoutServico = checkinCheckoutServico;
        this.configuracaoServico = configuracaoServico;
        this.registradorServico = registradorServico;
    }

    @PostMapping("/chefe")
    public Chefe criarChefe(@RequestBody Chefe chefe) {
        return chefeServico.criarChefe(chefe);
    }

    @GetMapping("/chefe")
    public List<Chefe> buscarChefe() {
        return chefeServico.buscarChefe();
    }

    @PostMapping("/contratar/{chefeId}")
    public Funcionario contratarFuncionario(@PathVariable String chefeId, @RequestBody Funcionario funcionario) {
        Chefe chefe = chefeServico.buscarChefe(chefeId).orElseThrow(() -> new RuntimeException(("Chefe não encontrado")));
        funcionario.setChefe(chefe);
        return funcionarioServico.criarFuncionario(funcionario);
    }

}
