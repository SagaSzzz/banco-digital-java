package Menu;

import model.Cliente;
import model.Conta;
import service.BancoService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private BancoService bancoService;

    public Menu(BancoService bancoService) {
        this.bancoService = bancoService;
    }

    public void iniciarMetodo(){
    iniciarEscolha();
}


private void listadeEscolha(){
    System.out.println("ESCOLHA UMA OPCAO:\n");
    System.out.println("1- CRIAR CONTA");
    System.out.println("2- BUSCAR CONTA");
    System.out.println("3- LISTAR CONTA");
    System.out.println("4- DEPOSITAR DINHEIRO");
    System.out.println("5- TRANSFERIR DINHEIRO");
    System.out.println("6- SACAR DINHEIRO");
    System.out.println("0- SAIR");
}


private void iniciarEscolha(){
    int opcao = -1;
    while (opcao !=0) {
        listadeEscolha();
        opcao = scanner.nextInt();
        scanner.nextLine();

        try {


            if (opcao == 1) {
                criarConta();
            } else if (opcao == 2) {
                buscarContaPorNumero();
            } else if (opcao == 3) {
                bancoService.listarConta();
            } else if (opcao == 4) {
                depositar();
            } else if (opcao == 5) {
                transferir();
            } else if (opcao == 6) {
                sacar();
            }else if (opcao == 0) {
                break;
            }
            else {
                System.out.println("OPCAO INVALIDA");
            }
        } catch (RuntimeException erro){
            System.out.println("ERRO" + erro.getMessage());
        }
    }
}


public void criarConta(){
    System.out.println("DIGITE O NOME");
    String nome = scanner.next();
    scanner.nextLine();

    System.out.println("DIGITE O CPF");
    String cpf = scanner.next();
    scanner.nextLine();

    System.out.println("DIGITE O TELEFONE");
    String telefone = scanner.next();
    scanner.nextLine();

    System.out.println("DIGITE O EMAIL");
    String email = scanner.next();
    scanner.nextLine();

    Cliente cliente = new Cliente(nome, cpf, telefone, email);
    Conta contacriada = bancoService.criarConta(cliente);
    System.out.println("CONTA CRIADA COM SUCESSO");
    System.out.println("Conta N: " + contacriada.getNumero());

}


public void buscarContaPorNumero(){
    System.out.println("DIGITE O NUMERO DA CONTA");
    int escolha = scanner.nextInt();
    Conta conta = bancoService.procurarPorId(escolha);
    Cliente titular = conta.getTitular();
    System.out.println("Conta: " + conta.getNumero());
    System.out.println("Titular: " + conta.getTitular().getNome());
    System.out.println("Saldo: R$" + conta.getSaldo());
    System.out.println("Cpf: " + titular.getCpf());
    System.out.println("Email: " + titular.getEmail());
    System.out.println("Telefone: " + titular.getTelefone());
    System.out.println("-----------------------------------");
}

private void sacar(){
    System.out.println("NUMERO DA CONTA");
    int numeroConta = scanner.nextInt();
    scanner.nextLine();
    System.out.println("VALOR DO SAQUE");
    double valorSaque = scanner.nextDouble();

    Conta conta = bancoService.procurarPorId(numeroConta);
    conta.sacar(valorSaque);
    System.out.println("SAQUE REALIZADO");

}

private void depositar(){
    System.out.println("NUMERO DA CONTA:");
    int numeroConta = scanner.nextInt();
    scanner.nextLine();
    System.out.println("QUANTO VOCE DESEJA DEPOSITAR?");
    double escolha = scanner.nextDouble();
    scanner.nextLine();
Conta conta = bancoService.procurarPorId(numeroConta);
conta.depositar(escolha);
    System.out.println("DEPOSITO BEM SUCEDIDO");
}

private void transferir(){
    System.out.println("QUAL CONTA DESEJA TRANSFERIR O SALDO?");
    int contaPagamento = scanner.nextInt();
    scanner.nextLine();

    System.out.println("QUAL CONTA DESEJA RECEBER A TRANSFERENCIA?");
    int contaRecebimeto = scanner.nextInt();
    scanner.nextLine();

    System.out.println("QUAL VALOR DA TRANSFERENCIA?");
    double valorTransferencia = scanner.nextDouble();

    Conta contaPG = bancoService.procurarPorId(contaPagamento);
    Conta contaRC = bancoService.procurarPorId(contaRecebimeto);

    contaPG.transferirSaldo(contaRC, valorTransferencia);

    System.out.println("TRANSFERENCIA BEM SUCEDIDA");


}




}
