package com.calculoteste.wba.entity;
import com.calculoteste.wba.enumeration.TipoPessoa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente", uniqueConstraints = {
        @UniqueConstraint(columnNames = "documento")
})
public class Cliente{


    @Id
    private Long id;


    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoPessoa tipoPessoa;

    @Column(unique = true, nullable = false)
    private String documento;


    @Column
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}