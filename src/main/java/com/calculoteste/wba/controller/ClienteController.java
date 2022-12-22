package com.calculoteste.wba.controller;

// Classe ClienteController

import com.calculoteste.wba.entity.Cliente;
import com.calculoteste.wba.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/clientes")
    public Cliente criaCliente(@RequestBody Cliente cliente) {
        return clienteService.criaCliente(cliente);
    }

    @GetMapping("/clientes/{id}")
    public Optional<Cliente> buscaClientePorId(@PathVariable Long id) {
        return clienteService.buscaClientePorId(id);
    }

    // Métodos adicionais aqui, se necessário
}
