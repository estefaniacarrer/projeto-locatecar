package util;

import enums.TipoDeCliente;
import enums.TipoVeiculo;
import model.Cliente;
import model.Veiculo;

public class DadosUtil {

    public static Cliente[] criarClientes() {
        Cliente cliente1 = new Cliente("12345678901", "João da Silva", "16988884444", TipoDeCliente.PESSOAFISICA); // Pessoa Física
        Cliente cliente2 = new Cliente("98765432101", "Empresa XYZ", "16988883333", TipoDeCliente.PESSOAJURIDICA);  // Pessoa Jurídica
        Cliente cliente3 = new Cliente("55555555555", "Maria Souza", "16988882222", TipoDeCliente.PESSOAFISICA);
        Cliente cliente4 = new Cliente("22222222222", "Empresa ABC", "16988881111", TipoDeCliente.PESSOAJURIDICA);
        Cliente cliente5 = new Cliente("77777777777", "Carlos Santos", "16988880000", TipoDeCliente.PESSOAFISICA);
        Cliente cliente6 = new Cliente("33333333333", "Empresa QWERTY", "16988887777", TipoDeCliente.PESSOAJURIDICA);

        return new Cliente[]{cliente1, cliente2, cliente3, cliente4, cliente5, cliente6};
    }

    public static Veiculo[] criarVeiculos() {
        Veiculo veiculo1 = new Veiculo("ABC123", "Fiat", TipoVeiculo.PEQUENO,true);
        Veiculo veiculo2 = new Veiculo("DEF456", "Chevrolet", TipoVeiculo.MEDIO, true);
        Veiculo veiculo3 = new Veiculo("GHI789", "Fiat", TipoVeiculo.SUV, true);
        Veiculo veiculo4 = new Veiculo("JKL101", "Volkswagen", TipoVeiculo.PEQUENO, true);
        Veiculo veiculo5 = new Veiculo("MNO202", "Toyota", TipoVeiculo.MEDIO, false);
        Veiculo veiculo6 = new Veiculo("PQR303", "Hyundai", TipoVeiculo.SUV, true);

        return new Veiculo[]{veiculo1, veiculo2, veiculo3, veiculo4, veiculo5, veiculo6};
    }
}