package service;

import model.Veiculo;
import util.DadosUtil;

import java.util.*;

public class VeiculoService {
    private Map<String, Veiculo> veiculos = new HashMap<>();

    public VeiculoService() {
        Veiculo[] veiculosIniciais = DadosUtil.criarVeiculos();
        for (Veiculo veiculo : veiculosIniciais) {
            cadastrarVeiculo(veiculo);
        }
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (!veiculos.containsKey(veiculo.getPlaca())) {
            veiculos.put(veiculo.getPlaca(), veiculo);
        } else {
            throw new IllegalArgumentException("Veículo com a mesma placa já cadastrado.");
        }
    }

    public Set<Veiculo> buscarVeiculosPorModelo(String modelo) {
        Set<Veiculo> veiculosEncontrados = new HashSet<>();
        for (Veiculo veiculo : veiculos.values()) {
            if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                veiculosEncontrados.add(veiculo);
            }
        }
        return veiculosEncontrados;
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return veiculos.get(placa);
    }

    public void listarVeiculosDisponiveis() {
        System.out.println("----- Lista de Veículos Disponíveis -----");
        for (Veiculo veiculo : veiculos.values()) {
            if (veiculo.isDisponivel()) {
                System.out.println("Placa: " + veiculo.getPlaca() + ", Modelo: " + veiculo.getModelo() + ", Tipo: " + veiculo.getTipo());
            }
        }
    }
}
