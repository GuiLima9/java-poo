import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        ContaBanco p1 = new ContaBanco();
        p1.setNumConta(1111);
        p1.setDono("Elinelson");
        p1.abrirConta("CC");
        p1.depositar(100);
        p1.sacar(25);
        p1.pagarMensal();
        banco.adicionarConta(p1);

        banco.consultarSaldo(1111);
        banco.exibirHistorico(1111);

        ContaBanco p2 = new ContaBanco();
        p2.setNumConta(22222);
        p2.setDono("Smiriana");
        p2.abrirConta("CP");
        p2.depositar(500);
        p2.sacar(100);
        p2.pagarMensal();
        banco.adicionarConta(p2);

        banco.consultarSaldo(22222);
        banco.exibirHistorico(22222);
    }
}
