package com.calculoteste.wba.controller;

import com.calculoteste.wba.entity.Cliente;
import com.calculoteste.wba.entity.Recebivel;
import com.calculoteste.wba.repository.ClienteRepository;
import com.calculoteste.wba.repository.RecebivelRepository;
import com.calculoteste.wba.service.RecebivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@RestController
public class RecebivelController {

    @Autowired
    private RecebivelRepository recebivelRepository;


    private RecebivelService recebivelService;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/recebiveis")
    public Recebivel criaRecebivel(@RequestParam double valor,
                                   @RequestParam LocalDate dataVencimento,
                                   @RequestParam String documentoCliente,
                                   @RequestParam int prazo) {
        // Busca o Cliente pelo seu documento
        Cliente cliente = (Cliente) clienteRepository.findByDocumento(documentoCliente).get(0);

        Recebivel recebivel = null;
        //necessário existir o cliente para inserir um recebível
        if (cliente != null) {
            recebivel = new Recebivel(cliente);
            recebivel.setValor(valor);
            recebivel.setDataVencimento(dataVencimento);
            recebivel.setPrazo(prazo);
            recebivel.setDocumentoCliente(cliente.getDocumento());
            recebivel.setNomeCliente(cliente.getNome());

            double calculo = switch (((Cliente) cliente).getTipoPessoa()) {
                case PJ -> {
                    yield  valor * 0.03 * 30 + prazo;

                }
                case PF -> {
                    yield  valor * 0.015 * 30 * prazo;

                }
            };
            recebivel.setValorTotalCalculado(calculo);
            recebivelService.criaRecebivel(cliente.getId(), recebivel);

        } else {
            return null;
        }

        return recebivel;
    }

    @GetMapping("/infoRecebivelCliente")
    public ResponseEntity<List<Recebivel>> infoRecCli() {

        List<Recebivel> recebiveisClientes =
                recebivelRepository.findByOrderByValorDataVencimentoPrazoDocumentoClienteNomeClienteValorTotalCalculado();

    return ResponseEntity.ok(recebiveisClientes);
    }
}