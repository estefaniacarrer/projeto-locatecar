package service.aluguelservice;

import enums.TipoDeCliente;
import enums.TipoVeiculo;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class LocacaoService {

    private List<Aluguel> alugueis = new ArrayList<>();
    public LocacaoService(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public double alugarVeiculo(Cliente cliente, Veiculo veiculo, LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (!veiculo.isDisponivel()) {
            System.out.println("Veículo não disponível para locação.");
            return 0;
        }

        TipoDeCliente tipoCliente = cliente.getTipoDeCliente();
        TipoVeiculo tipoVeiculo = veiculo.getTipo();

        double valorDiaria = calcularValorDiaria(tipoVeiculo);
        long minutosLocacao = ChronoUnit.MINUTES.between(dataInicio, dataFim);

        // número de diárias considerando 24 horas por dia
        long diasLocacao = minutosLocacao / (24 * 60);
        if (minutosLocacao % (24 * 60) > 0) {
            diasLocacao++;
        }

        //desconto
        double desconto = 0.0;
        if (tipoCliente == TipoDeCliente.PESSOAFISICA && diasLocacao > 5) {
            desconto = 0.05;
        } else if (tipoCliente == TipoDeCliente.PESSOAJURIDICA && diasLocacao > 3) {
            desconto = 0.10;
        }

        double valorTotal = (valorDiaria * diasLocacao) * (1 - desconto);

        Aluguel aluguel = new Aluguel(veiculo, cliente, dataInicio, dataFim, valorTotal);
        veiculo.setDisponivel(false);
        alugueis.add(aluguel);

        return valorTotal;
    }

    private double calcularValorDiaria(TipoVeiculo tipoVeiculo) {
        switch (tipoVeiculo) {
            case PEQUENO:
                return TipoVeiculo.PEQUENO.getValorDiaria();
            case MEDIO:
                return TipoVeiculo.MEDIO.getValorDiaria();
            case SUV:
                return TipoVeiculo.SUV.getValorDiaria();
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido.");
        }
    }

    public void listarAlugueis () {
        if (alugueis.isEmpty()) {
            System.out.println("Não há aluguéis registrados.");
        } else {
            for (Aluguel aluguel : alugueis) {
                System.out.println("Cliente: " + aluguel.getCliente().getNome() + ", Veículo: " + aluguel.getVeiculo().getPlaca());
            }
        }
    }
}
