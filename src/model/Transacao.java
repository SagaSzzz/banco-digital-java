package model;

import enums.StatusTransacao;

import java.time.LocalDate;

public class Transacao {
    private LocalDate data;
    private double valor;
    private StatusTransacao tipo;

    public Transacao(StatusTransacao tipo, double valor) {
        this.data = LocalDate.now();
        this.valor = valor;
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public StatusTransacao getTipo() {
        return tipo;
    }
}
