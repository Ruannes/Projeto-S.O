package com.checkIN_checkOUT.demo.controlador;

import com.checkIN_checkOUT.demo.modelos.Funcionario;
import com.checkIN_checkOUT.demo.servico.FuncionarioServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioControlador {
    private final FuncionarioServico funcionarioServico;
    private final com.checkIN_checkOUT.demo.servico.FuncionarioServico FuncionarioServico;

    public FuncionarioControlador(com.checkIN_checkOUT.demo.servico.FuncionarioServico funcionarioServico1, FuncionarioServico funcionarioServico) {
        this.funcionarioServico = funcionarioServico1;
        this.FuncionarioServico = funcionarioServico;
    }

    @PostMapping
    public Funcionario criarFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioServico.criarFuncionario(funcionario);
    }

    @GetMapping
    public List<Funcionario> listarFuncionarios(){
        return funcionarioServico.buscarFuncionario();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> listarFuncionario(@PathVariable String id){
        return funcionarioServico.buscarFuncionario(id);
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@RequestBody Funcionario funcionario, @PathVariable String id){
        Optional<Funcionario> funcionarioExistente = funcionarioServico.buscarFuncionario(id);
        if(funcionarioExistente.isEmpty()){
            return null;
        }else {
            funcionarioServico.atualizarFuncionario(funcionario);
            return funcionario;
        }
    }

    @DeleteMapping("/{id}")
    public Optional<Funcionario> removerFuncionario(@PathVariable String id) {
        Optional <Funcionario> funcionarioExistente = funcionarioServico.buscarFuncionario(id);
        funcionarioServico.excluirFuncionario(id);
        return funcionarioExistente;

    }
}
