package com.br.buscarcep.modelo;

public class Cep {
    private int cep;
    private String logradouro;
    private String bairro;
    private String cidade;

    public Cep(){}
    public Cep(CepRecord cepRecord){
        this.cep = Integer.valueOf(cepRecord.cep().replace("-", ""));
        this.logradouro = cepRecord.logradouro();
        this.bairro = cepRecord.bairro();
        this.cidade = cepRecord.localidade();
    }

    public int getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return   "Cidade: "
                + getCidade()
                + ", Bairro: "
                + getBairro()
                + ", Rua: "
                + getLogradouro()
                + ", Cep: "
                + getCep();
    }
}
