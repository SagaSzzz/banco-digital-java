import model.Cliente;
import model.Conta;
import service.BancoService;

public class main {
    public static void main(String[] args) {


       BancoService bancoService = new BancoService();

        Cliente cliente1 = new Cliente("CAIO", "934902384", "219999999", "CAIO@GMAIL.COM");
        Cliente cliente2 = new Cliente("RAFA", "22332124", "21888888", "RAFA@GMAIL.COM");

        Conta conta1 = bancoService.criarConta(cliente1);
        Conta conta2 = bancoService.criarConta(cliente2);

        conta1.depositar(1000000);
        conta2.depositar(5000);


        bancoService.listarConta();











    }
}