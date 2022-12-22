package com.calculoteste.wba.service;

import com.calculoteste.wba.entity.Cliente;
import com.calculoteste.wba.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscaClientePorId(Long id) {
        return clienteRepository.findById(id);
    }
}