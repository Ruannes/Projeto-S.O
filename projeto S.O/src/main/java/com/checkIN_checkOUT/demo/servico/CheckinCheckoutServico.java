package com.checkIN_checkOUT.demo.servico;

import com.checkIN_checkOUT.demo.modelos.RegistroCheckinCheckout;
import com.checkIN_checkOUT.demo.repositorios.CheckinCheckoutRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckinCheckoutServico {
    private CheckinCheckoutRepositorio checkinCheckoutRepositorio;

    public CheckinCheckoutServico(CheckinCheckoutRepositorio checkinCheckoutRepositorio) {
        this.checkinCheckoutRepositorio = checkinCheckoutRepositorio;
    }

    public RegistroCheckinCheckout criarCheckinCheckout(RegistroCheckinCheckout checkinCheckout) {
        return checkinCheckoutRepositorio.save(checkinCheckout);
    }

    public List<RegistroCheckinCheckout> buscarCheckinCheckout() {
        return checkinCheckoutRepositorio.findAll();
    }

    public Optional<RegistroCheckinCheckout> buscarChechinCheckout(String id){
        return checkinCheckoutRepositorio.findById(id);
    }

    public void atualizarCheckinCheckout(RegistroCheckinCheckout checkinCheckout) {
        checkinCheckoutRepositorio.save(checkinCheckout);
    }

    public void excluirCheckinCheckout(String id){
        checkinCheckoutRepositorio.deleteById(id);
    }
}
