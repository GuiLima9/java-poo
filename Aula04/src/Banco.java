import java.util.Map;
import java.util.HashMap;

public class Banco {
    private final Map<Integer, ContaBanco> contas;

    // Construtor
    public Banco() {
        this.contas = new HashMap<>();
    }

    // Adicionar conta ao banco
    public void adicionarConta(ContaBanco conta) {
        contas.put(conta.getNumConta(), conta);
    }

    // Consultar saldo de uma conta
    public void consultarSaldo(int numConta) {
        ContaBanco conta = contas.get(numConta);
        if (conta != null) {
            conta.consultarSaldo();
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    // Exibir histórico de transações de uma conta
    public void exibirHistorico(int numConta) {
        ContaBanco conta = contas.get(numConta);
        if (conta != null) {
            conta.exibirHistorico();
        } else {
            System.out.println("Conta não encontrada!");
        }
    }
}

