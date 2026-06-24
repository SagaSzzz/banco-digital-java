package service;

import exception.ContaNaoAchadaException;
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

    public Conta procurarPorId(int numero){
        for (Conta conta : contas){
            if (conta.getNumero() == numero){
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



}
