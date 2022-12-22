package com.calculoteste.wba.repository;

import com.calculoteste.wba.entity.Recebivel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecebivelRepository extends JpaRepository<Recebivel, Long> {


    List<Recebivel> findByOrderByValorDataVencimentoPrazoDocumentoClienteNomeClienteValorTotalCalculado();


}
