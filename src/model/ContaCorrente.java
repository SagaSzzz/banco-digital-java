package model;

public class ContaCorrente extends Conta{

    private static final double TAXA_SAQUE = 2.0;
    public ContaCorrente(Cliente titular){
        super(titular);
    }
    @Override
    public void sacar(double valor){
        double valorComtaxa = valor + TAXA_SAQUE;
        super.sacar(valorComtaxa);
    }

    @Override
    public String getTipoConta(){
        return "CONTA CORRENTE";
    }


}
