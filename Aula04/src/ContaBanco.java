import java.util.List;
import java.util.ArrayList;

public final class ContaBanco implements CaixaEletronico {
    private int numConta;
    private String tipo;
    private String dono;
    private double saldo;
    private boolean status;
    private List<String> historicoTransacoes;

    // Construtor
    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
        this.historicoTransacoes = new ArrayList<>();
    }

    // Método para registrar transação
    public void registrarTransacao(String transacao) {
        historicoTransacoes.add(transacao);
    }

    // Exibe o histórico de transações
    public void exibirHistorico() {
        System.out.println("Histórico de Transações:");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }

    // Métodos de acesso e modificadores
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getDono() {
        return dono;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    // Abrir conta
    public void abrirConta(String modalidade) {
        this.setTipo(modalidade);
        this.setStatus(true);
        if (modalidade.equals("CC") || modalidade.equals("CP")) {
            this.setSaldo(0);
        }
        registrarTransacao("Conta aberta: " + modalidade);
        System.out.println("Conta Aberta com sucesso!");
    }

    // Fechar conta
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta não pode ser fechada pois ainda há saldo");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta não pode ser fechada pois há débito");
        } else {
            this.setStatus(false);
            registrarTransacao("Conta fechada com sucesso.");
            System.out.println("Conta fechada com sucesso!");
        }
    }

    // Depositar
    @Override
    public void depositar(double valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            registrarTransacao("Depósito de R$ " + valor);
            System.out.println("Depósito realizado na conta de: " + this.getDono());
        } else {
            System.out.println("Impossível efetuar depósito em conta fechada");
        }
    }

    // Sacar
    @Override
    public void sacar(double valor) {
        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                registrarTransacao("Saque de R$ " + valor);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada");
        }
    }

    // Mensalidade
    public void pagarMensal() {
        double valor = 0;
        if (this.tipo.equals("CC")) {
            valor = 12;
        } else if (this.tipo.equals("CP")) {
            valor = 20;
        }
        if (this.status) {
            if (this.saldo >= valor) {
                this.saldo = this.saldo - valor;
                registrarTransacao("Mensalidade paga de R$ " + valor);
                System.out.println("Mensalidade de R$ " + valor + " paga por " + this.dono);
            } else {
                System.out.println("Saldo insuficiente para pagar mensalidade");
            }
        } else {
            System.out.println("Impossível pagar mensalidade de uma conta fechada.");
        }
    }

    @Override
    public void consultarSaldo() {
        if (this.status) {
            System.out.println("Seu saldo atual é: " + this.saldo);
        } else {
            throw new IllegalStateException("Conta inativa, saldo não disponível");
        }
    }
}
