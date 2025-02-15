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

    /**
     * Realiza check-in de um funcionário
     */
    @PostMapping("/checkin/{funcionarioId}")
    public RegistroCheckinCheckout realizarCheckin(@PathVariable Long funcionarioId) {
        Funcionario funcionario = funcionarioServico.buscarFuncionario(String.valueOf(funcionarioId))
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        return checkinCheckoutServico.realizarCheckin(funcionario);
    }

    /**
     * Realiza check-out de um funcionário
     */
    @PostMapping("/checkout/{funcionarioId}")
    public RegistroCheckinCheckout realizarCheckout(@PathVariable Long funcionarioId) {
        Funcionario funcionario = funcionarioServico.buscarFuncionario(String.valueOf(funcionarioId))
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        return checkinCheckoutServico.realizarCheckout(funcionario);
    }

    /**
     * Lista todos os registros de check-in/check-out
     */
    @GetMapping("/registros")
    public List<RegistroCheckinCheckout> listarRegistros() {
        return checkinCheckoutServico.buscarCheckinCheckout();
    }

    /**
     * Busca um registro específico pelo ID
     */
    @GetMapping("/registro/{id}")
    public RegistroCheckinCheckout buscarRegistro(@PathVariable Long id) {
        return checkinCheckoutServico.buscarCheckinCheckout(id)
                .orElseThrow(() -> new RuntimeException("Registro não encontrado"));
    }

    /**
     * Exclui um registro pelo ID
     */
    @DeleteMapping("/registro/{id}")
    public void excluirRegistro(@PathVariable Long id) {
        checkinCheckoutServico.excluirCheckinCheckout(id);
    }

    /**
     * Cria uma configuração de banco de horas vinculada a um chefe
     */
    @PostMapping("/configuracao/{chefeId}")
    public <Configuracao> Configuracao criarConfiguracao(@PathVariable Long chefeId, @RequestBody Configuracao configuracao) {
        Chefe chefe = chefeServico.buscarChefe(String.valueOf(chefeId))
                .orElseThrow(() -> new RuntimeException("Chefe não encontrado"));
        configuracao.getClass();
        return (Configuracao) configuracaoServico.criarConfiguracao((ConfiguracaoChefe) configuracao);
    }
}

