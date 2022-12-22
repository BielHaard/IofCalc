package com.calculoteste.wba.enumeration;

public enum TipoPessoa {
    PJ("Pessoa Juridica"), PF("Pessoa Física") ;

    private final String tipoPessoa;
    TipoPessoa(String tipoPessoa) {

        this.tipoPessoa = tipoPessoa;

    }

    public String getTipoPessoa(){
        return tipoPessoa;
    }

}
