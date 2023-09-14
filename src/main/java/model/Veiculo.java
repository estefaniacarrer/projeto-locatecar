package model;

import enums.TipoVeiculo;

public class Veiculo {
    private String placa;
    private String modelo;
    private TipoVeiculo tipo;
    private boolean disponivel = true;

    public Veiculo(String placa, String modelo, TipoVeiculo tipo, boolean disponivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
        this.disponivel = disponivel;
    }

    public Veiculo(String placa, String modelo, TipoVeiculo tipo) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", tipo=" + tipo +
                ", disponivel=" + disponivel +
                '}';
    }
}
