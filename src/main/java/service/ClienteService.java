package service;

import model.Cliente;
import model.Veiculo;
import util.DadosUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteService {
    private Map<String, Cliente> clientes = new HashMap<>();

    public ClienteService() {
        Cliente[] clientesIniciais = DadosUtil.criarClientes();
        for (Cliente cliente : clientesIniciais) {
            cadastrarCliente(cliente);
        }
    }
    public void cadastrarCliente(Cliente cliente) {
        if (!clientes.containsKey(cliente.getCpfCnpj())) {
            clientes.put(cliente.getCpfCnpj(), cliente);
        } else {
            throw new IllegalArgumentException("Cliente já cadastrado no sistema.");
        }
    }

    public Cliente buscarClientePorDocumento(String cpfCnpj) {
        for (Cliente cliente : DadosUtil.criarClientes()) {
            if (cliente.getCpfCnpj().equals(cpfCnpj)) {
                return cliente;
            }
        }
        for (Cliente cliente : clientes.values()) {
            if (cliente.getCpfCnpj().equals(cpfCnpj)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarClientes() {
        System.out.println("----- Lista de Clientes -----");
        for (Cliente cliente : clientes.values()) {
            System.out.println("Nome: " + cliente.getNome() + ", Documento: " + cliente.getCpfCnpj() + ", Tipo: " + cliente.getTipoDeCliente());
        }
    }

}