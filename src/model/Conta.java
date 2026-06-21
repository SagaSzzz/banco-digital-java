package model;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;
import Enum.StatusTransacao;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private static int contador = 1;
    private double saldo;
    private Cliente titular;
    private int numero;

    private List<Transacao> extrato = new ArrayList<>();

    public Conta(Cliente titular) {
        this.titular = titular;
        this.saldo = 0.0;
        this.numero  = contador++;
    }
    public void sacar(double valor){
        if (valor > saldo){
            throw new SaldoInsuficienteException(": RETIRADA NAO PERMITIDA");
        }
        if (valor <=0){
            throw new ValorInvalidoException(": VALOR NAO ACEITO");
        }
        saldo -= valor;
        extrato.add(new Transacao(StatusTransacao.SAQUE, valor));

    }

    public void depositar(double valor){
        if (valor <=0){
            throw new ValorInvalidoException(": VALOR DE DEPOSITO NAO PERMITIDO");
        }
        saldo += valor;
        extrato.add(new Transacao(StatusTransacao.DEPOSITO, valor));

    }
    public void transferirSaldo(Conta contaCliente, double valor){
        this.sacar(valor);
        contaCliente.depositar(valor);
    }

    public void mostrarExtrato(){
        System.out.println("-----------EXTRATO DA CONTA " + numero + "---------");
        if (extrato.isEmpty()){
            System.out.println("EXTRATO NAO ENCONTRADO");
            return;
        }
        for (Transacao transacao : extrato){
            System.out.println("Tipo: " + transacao.getTipo());
            System.out.println("Valor: R$ " + transacao.getValor());
            System.out.println("Data: " + transacao.getData());
            System.out.println("-----------------------------------");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }
}
