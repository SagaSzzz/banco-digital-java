package menu;

import model.Cliente;
import model.Conta;
import service.BancoService;

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
    System.out.println("1- Criar conta");
    System.out.println("2- Buscar conta");
    System.out.println("3- Listar conta");
    System.out.println("4- Deposito");
    System.out.println("5- Transferencia");
    System.out.println("6- Saque");
    System.out.println("7- Deletar conta");
    System.out.println("8- Conferir extrato");
    System.out.println("0- Sair");
}


private void iniciarEscolha(){
    int numero = -1;
    while (numero !=0) {
        listadeEscolha();
        String opcao = scanner.next();
        scanner.nextLine();

        try {
            if (opcao.equals("1")) {
                criarConta();
            }
            else if (opcao.equals("2")) {
                buscarContaPorNumero();
            }
            else if (opcao.equals("3")) {
                bancoService.listarConta();
            }
            else if (opcao.equals("4")) {
                depositar();
            }
            else if (opcao.equals("5")) {
             transferir();
            }
            else if (opcao.equals("6")) {
                sacar();
            }
            else if (opcao.equals("7")) {
                deletarConta();
            }
            else if (opcao.equals("8")) {
                verExtrato();
            } else if (opcao.equals("0")) {
                break;

            } else {
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

    System.out.println("TIPO DE CONTA");
    System.out.println("1 - CONTA CORRENTE / 2 - CONTA POUPANCA");
    String opcaoConta = scanner.next();
    scanner.nextLine();

    Cliente cliente = new Cliente(nome, cpf, telefone, email);

    Conta contaCriada;

    if (opcaoConta.equals("1")) {
        contaCriada = bancoService.criarConta(cliente);
    }
    else if (opcaoConta.equals("2")) {
       contaCriada = bancoService.criarContaPoupanca(cliente);
    }
    else {
        System.out.println("OPCAO INVALIDA");
        return;
    }

    System.out.println("CONTA CRIADA COM SUCESSO");
    System.out.println("Conta N: " + contaCriada.getNumero());
    System.out.println("Conta N: " + contaCriada.getTipoConta());
}


public void buscarContaPorNumero(){
    System.out.println("DIGITE O NUMERO DA CONTA");
    String escolha = scanner.next();
    scanner.nextLine();

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
    String numeroConta = scanner.next();
    scanner.nextLine();
    System.out.println("VALOR DO SAQUE");
    double valorSaque = scanner.nextDouble();

    Conta conta = bancoService.procurarPorId(numeroConta);
    conta.sacar(valorSaque);
    System.out.println("SAQUE REALIZADO");

}

private void depositar(){
    System.out.println("NUMERO DA CONTA:");
    String numeroConta = scanner.next();
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
    String contaPagamento = scanner.next();
    scanner.nextLine();

    System.out.println("QUAL CONTA DESEJA RECEBER A TRANSFERENCIA?");
    String contaRecebimeto = scanner.next();
    scanner.nextLine();

    System.out.println("QUAL VALOR DA TRANSFERENCIA?");
    double valorTransferencia = scanner.nextDouble();

    Conta contaPG = bancoService.procurarPorId(contaPagamento);
    Conta contaRC = bancoService.procurarPorId(contaRecebimeto);

    contaPG.transferirSaldo(contaRC, valorTransferencia);

    System.out.println("TRANSFERENCIA BEM SUCEDIDA");
}

public void verExtrato(){
    System.out.println("DIGITE O NUMERO DA CONTA");
    String numero = scanner.next();
    scanner.nextLine();

    Conta conta = bancoService.procurarPorId(numero);
    conta.mostrarExtrato();
}

    private void deletarConta(){
        System.out.println("DIGITE O NUMERO DA CONTA:");
        String numeroConta = scanner.next();
        scanner.nextLine();

        System.out.println("TEM CERTEZA QUE DESEJA EXCLUIR A CONTA? (1 - SIM / 2- NAO)");
        String opcao = scanner.next();
        scanner.nextLine();

        if (opcao.equals("1")){
            bancoService.deletarConta(numeroConta);
            System.out.println("CONTA EXCLUIDA COM SUCESSO.");
        } else if (opcao.equals("2")){
            System.out.println("OPERACAO CANCELADA.");
        } else {
            System.out.println("OPERACAO INVALIDA, CANCELADA.");
        }

    }


}
