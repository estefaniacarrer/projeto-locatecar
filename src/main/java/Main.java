import enums.TipoVeiculo;
import enums.TipoDeCliente;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;
import service.ClienteService;
import service.VeiculoService;
import service.aluguelservice.DevolucaoService;
import service.aluguelservice.LocacaoService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VeiculoService veiculoService = new VeiculoService();
        ClienteService clienteService = new ClienteService();
        List<Aluguel> alugueis = new ArrayList<>();
        LocacaoService locacaoService = new LocacaoService(alugueis);
        DevolucaoService devolucaoService = new DevolucaoService(alugueis);

        while (true) {
            System.out.println("----- ADA LocateCar -----");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Alterar Veiculo");
            System.out.println("4. Alterar Cliente");
            System.out.println("5. Buscar Veiculo por Modelo");
            System.out.println("6. Listar Veículos Disponíveis");
            System.out.println("7. Listar Clientes");
            System.out.println("8. Listar Aluguéis");
            System.out.println("9. Alugar Veículo");
            System.out.println("10. Devolver Veículo");
            System.out.println("11. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Placa do Veículo: ");
                    String placa = scanner.next();
                    System.out.print("Modelo do Veículo: ");
                    String modelo = scanner.next();
                    System.out.print("Tipo do Veículo (PEQUENO, MEDIO ou SUV): ");
                    TipoVeiculo tipoVeiculo = TipoVeiculo.valueOf(scanner.next().toUpperCase());
                    Veiculo veiculo = new Veiculo(placa, modelo, tipoVeiculo);
                    try {
                        veiculoService.cadastrarVeiculo(veiculo);
                        System.out.println("Veículo cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Nome do Cliente: ");
                    String nome = scanner.next();
                    System.out.print("Telefone do Cliente: ");
                    String telefone = scanner.next();
                    System.out.print("Tipo do Cliente (PESSOAFISICA ou PESSOAJURIDICA): ");
                    TipoDeCliente tipoDeCliente = TipoDeCliente.valueOf(scanner.next().toUpperCase());
                    System.out.print("Documento do Cliente (CPF ou CNPJ): ");
                    String documento = scanner.next();
                    Cliente cliente = new Cliente(documento, nome, telefone, tipoDeCliente);
                    try {
                        clienteService.cadastrarCliente(cliente);

                        System.out.println("Cliente cadastrado com sucesso!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Placa do Veículo a ser alterado: ");
                    String placaAlteracao = scanner.next();
                    Veiculo veiculoParaAlterar = veiculoService.buscarVeiculoPorPlaca(placaAlteracao);

                    if (veiculoParaAlterar != null) {
                        System.out.print("Novo Tipo do Veículo (PEQUENO, MEDIO ou SUV): ");
                        TipoVeiculo novoTipoVeiculo = TipoVeiculo.valueOf(scanner.next().toUpperCase());
                        veiculoParaAlterar.setTipo(novoTipoVeiculo);

                        System.out.println("Veículo alterado com sucesso!");
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Documento do Cliente a ser alterado (CPF ou CNPJ): ");
                    String documentoAlteracao = scanner.next();
                    Cliente clienteParaAlterar = clienteService.buscarClientePorDocumento(documentoAlteracao);

                    if (clienteParaAlterar != null) {
                        System.out.print("Novo Nome do Cliente: ");
                        String novoNomeCliente = scanner.next();
                        scanner.nextLine();
                        clienteParaAlterar.setNome(novoNomeCliente);
                        System.out.print("Novo Telefone do Cliente: ");
                        String novoTelefoneCliente = scanner.nextLine();
                        clienteParaAlterar.setTelefone(novoTelefoneCliente.trim());

                        System.out.println("Cliente alterado com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o modelo do veículo: ");
                    String modeloVeiculo = scanner.next();
                    Set<Veiculo> veiculosEncontrados = veiculoService.buscarVeiculosPorModelo(modeloVeiculo);

                    if (!veiculosEncontrados.isEmpty()) {
                        System.out.println("Veículos encontrados do modelo " + modeloVeiculo + ":");
                        for (Veiculo veiculoL : veiculosEncontrados) {
                            System.out.println(veiculoL.toString());
                        }
                    } else {
                        System.out.println("Nenhum veículo do modelo " + modeloVeiculo + " encontrado.");
                    }
                    break;

                case 6:
                    veiculoService.listarVeiculosDisponiveis();
                    break;

                case 7:
                    clienteService.listarClientes();
                    break;

                case 8:
                    locacaoService.listarAlugueis();
                    break;

                case 9:
                    System.out.print("Digite o CPF/CNPJ do cliente: ");
                    String documentoCliente = scanner.next();
                    Cliente clienteParaLocacao = clienteService.buscarClientePorDocumento(documentoCliente);

                    if (clienteParaLocacao != null) {
                        System.out.print("Placa do veículo a ser alugado: ");
                        String placaVeiculo = scanner.next();
                        Veiculo veiculoParaLocacao = veiculoService.buscarVeiculoPorPlaca(placaVeiculo);

                        if (veiculoParaLocacao != null) {
                            scanner.nextLine();
                            System.out.print("Data de início (yyyy-MM-dd HH:mm): ");
                            String dataInicioStr = scanner.nextLine();
                            LocalDateTime dataInicio = LocalDateTime.parse(dataInicioStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                            System.out.print("Data de fim (yyyy-MM-dd HH:mm): ");
                            String dataFimStr = scanner.nextLine();
                            LocalDateTime dataFim = LocalDateTime.parse(dataFimStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                            double valorTotal = locacaoService.alugarVeiculo(clienteParaLocacao, veiculoParaLocacao, dataInicio, dataFim);

                            System.out.println("Locação realizada com sucesso. Valor Total: R$ " + valorTotal);
                        } else {
                            System.out.println("Veículo não encontrado.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 10:
                    System.out.print("Digite a placa do veículo a ser devolvido: ");
                    String placaVeiculoDevolucao = scanner.next();
                    Aluguel aluguelParaDevolucao = devolucaoService.buscarAluguelPorPlacaVeiculo(placaVeiculoDevolucao);

                    if (aluguelParaDevolucao != null) {
                        devolucaoService.devolverVeiculo(aluguelParaDevolucao);
                    } else {
                        System.out.println("Veículo não encontrado ou não está alugado.");
                    }
                    break;

                case 11:
                    System.out.println("Saindo do programa.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}