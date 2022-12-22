package com.calculoteste.wba.service;

import com.calculoteste.wba.entity.Cliente;
import com.calculoteste.wba.entity.Recebivel;
import com.calculoteste.wba.repository.ClienteRepository;
import com.calculoteste.wba.repository.RecebivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecebivelService {

    @Autowired
    private RecebivelRepository recebivelRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Recebivel criaRecebivel(Long idCliente, Recebivel novoRecebivel) {
        Cliente cliente = clienteRepository.findById(idCliente).get();
        return recebivelRepository.save(novoRecebivel);
    }
}