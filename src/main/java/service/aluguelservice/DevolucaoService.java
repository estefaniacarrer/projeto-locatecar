package service.aluguelservice;

import model.Aluguel;
import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class DevolucaoService {
    private List<Aluguel> alugueis = new ArrayList<>();

    public DevolucaoService(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public void devolverVeiculo(Aluguel aluguel) {
        Veiculo veiculo = aluguel.getVeiculo();
        veiculo.setDisponivel(true);
        alugueis.remove(aluguel);

        System.out.println("Veículo com placa " + veiculo.getPlaca() + " foi devolvido com sucesso.");
    }

    public Aluguel buscarAluguelPorPlacaVeiculo(String placaVeiculo) {
        for (Aluguel aluguel : alugueis) {
            String placaAluguel = aluguel.getVeiculo().getPlaca().trim();
            if (placaAluguel.equalsIgnoreCase(placaVeiculo.trim())) {
                return aluguel;
            }
        }
        return null;
    }
}
