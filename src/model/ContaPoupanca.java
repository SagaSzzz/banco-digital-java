package model;

public class ContaPoupanca extends Conta{
    public static final double RENDIMENTO_TAXA = 0.01;

    public ContaPoupanca(Cliente titular) {
        super(titular);
    }

    public  void valorRendimento(){
        double valorTotal = getSaldo() *  RENDIMENTO_TAXA;
        depositar(valorTotal);
    }
    @Override
    public  String getTipoConta(){
        return "CONTA POUPANCA";
    }

}
