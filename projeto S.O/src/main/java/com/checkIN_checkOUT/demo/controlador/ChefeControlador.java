package com.checkIN_checkOUT.demo.controlador;

import com.checkIN_checkOUT.demo.modelos.Chefe;
import com.checkIN_checkOUT.demo.servico.ChefeServico;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chefe")
public class ChefeControlador {
    private final ChefeServico chefeServico;

    public ChefeControlador(ChefeServico chefeServico) {
        this.chefeServico = chefeServico;
    }

    @PostMapping
    public Chefe criarChefe(@RequestBody Chefe chefe){
        return chefeServico.criarChefe(chefe);
    }

    @GetMapping
    public List<Chefe> listarChefe(){
        return chefeServico.buscarChefe();
    }

    @GetMapping("/{id}")
    public Optional<Chefe> listarChefe(@PathVariable String id){
        return chefeServico.buscarChefe(id);
    }

    @PutMapping("/{id}")
    public Chefe atualizarChefe(@RequestBody Chefe chefe, @PathVariable String id){
        Optional<Chefe> chefeExistente = chefeServico.buscarChefe(id);
        if(chefeExistente.isEmpty()){
            return null;
        }else {
            chefeServico.atualizarChefe(chefe);
            return chefe;
        }
    }

    @DeleteMapping("/{id}")
    public Optional<Chefe> removerChefe(@PathVariable String id) {
        Optional <Chefe> chefeExistente = chefeServico.buscarChefe(id);
        chefeServico.excluirChefe(id);
        return chefeExistente;

    }
}
