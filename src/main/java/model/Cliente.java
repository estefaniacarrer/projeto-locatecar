package model;

import enums.TipoDeCliente;

public class Cliente {
    private String cpfCnpj;
    private String nome;
    private String telefone;
    private TipoDeCliente tipoDeCliente;

    public Cliente(String cpfCnpj, String nome, String telefone, TipoDeCliente tipoDeCliente) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.tipoDeCliente = tipoDeCliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoDeCliente getTipoDeCliente() {
        return tipoDeCliente;
    }

    public void setTipoDeCliente(TipoDeCliente tipoDeCliente) {
        this.tipoDeCliente = tipoDeCliente;
    }
}
