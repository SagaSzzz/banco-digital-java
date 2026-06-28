package service;

import exception.ContaComSaldoException;
import exception.ContaNaoAchadaException;
import exception.NumeroContaInvalido;
import model.Cliente;
import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;

public class BancoService {

    private List<Conta> contas = new ArrayList<>();

    public Conta criarContaPoupanca(Cliente cliente){
        Conta conta = new ContaPoupanca(cliente);
        contas.add(conta);
        return conta;
    }
    public Conta criarConta(Cliente cliente){
        Conta conta = new ContaCorrente(cliente);
        contas.add(conta);
        return conta;
    }

    public Conta procurarPorId(String numero){
        int numeroConvertido;
        try{
            numeroConvertido  = Integer.parseInt(numero);
        } catch (NumberFormatException erro){
            throw new NumeroContaInvalido("NUMERO DA CONTA INVALIDO");
        }
        for (Conta conta : contas){
            if (conta.getNumero() == numeroConvertido){
                return conta;
            }
        } throw new ContaNaoAchadaException(": CONTA NAO ENCONTRADA");
    }

    public void listarConta(){
        for (Conta conta : contas) {
            Cliente titular = conta.getTitular();
            System.out.println("Conta: " + conta.getNumero());
            System.out.println("Tipo: " + conta.getTipoConta());
            System.out.println("Titular: " + conta.getTitular().getNome());
            System.out.println("Saldo: R$" + conta.getSaldo());
            System.out.println("Cpf: " + titular.getCpf());
            System.out.println("Email: " + titular.getEmail());
            System.out.println("Telefone: " + titular.getTelefone());
            System.out.println("-----------------------------------");
        }
    }

    public void deletarConta(String numero){
        Conta conta = procurarPorId(numero);

        if (conta.getSaldo() > 0){
            throw new ContaComSaldoException("CONTA COM SALDO NAO PODE SER EXCLUIDA");
        }
        contas.remove(conta);
    }

}
