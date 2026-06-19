import Menu.Menu;
import model.Cliente;
import model.Conta;
import service.BancoService;

public class main {
    public static void main(String[] args) {


       BancoService bancoService = new BancoService();

       Menu menu = new Menu(bancoService);
       menu.iniciarMetodo();














    }
}