package com.calculoteste.wba.repository;

import com.calculoteste.wba.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Map<Object, Object> findByDocumento(String documentoCliente);
}
