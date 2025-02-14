package com.checkIN_checkOUT.demo.servico;

import com.checkIN_checkOUT.demo.modelos.BancoDeHoras;
import com.checkIN_checkOUT.demo.repositorios.BancoHorasRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoHorasServico {
    private BancoHorasRepositorio bancoHorasRepositorio;

    public BancoHorasServico(BancoHorasRepositorio bancoHorasRepositorio) {
        this.bancoHorasRepositorio = bancoHorasRepositorio;
    }

    public BancoDeHoras criarBancoDeHoras(BancoDeHoras bancoDeHoras) {
        return bancoHorasRepositorio.save(bancoDeHoras);
    }

    public List<BancoDeHoras> buscarBancoDeHoras() {
        return bancoHorasRepositorio.findAll();
    }

    public Optional<BancoDeHoras> buscarBancoDeHoras(String id){
        return bancoHorasRepositorio.findById(id);
    }

    public void atualizarChefe(BancoDeHoras bancoDeHoras) {
        bancoHorasRepositorio.save(bancoDeHoras);
    }

    public void excluirBancoDeHoras(String id){
        bancoHorasRepositorio.deleteById(id);
    }
}
