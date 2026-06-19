package model;

import exception.SaldoInsuficienteException;
import exception.ValorInvalidoException;

public class Conta {
    private static int contador = 1;
    private double saldo;
    private Cliente titular;
    private int numero;

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
    }

    public void depositar(double valor){
        if (valor <=0){
            throw new ValorInvalidoException(": VALOR DE DEPOSITO NAO PERMITIDO");
        }
        saldo += valor;
    }
    public void transferirSaldo(Conta contaCliente, double valor){
        this.sacar(valor);
        contaCliente.depositar(valor);
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
