//attributes
public final class ContaBanco implements CaixaEletronico {
    private int numConta;
    private String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    public void estadoAtual() {
        System.out.println("Conta: " + this.numConta);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Dono: " + this.dono);
        System.out.println("Saldo: " + this.saldo);
        System.out.println("Status:" + this.status);
    }

    //metodos especiais(construtores)
    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    //numero da conta
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getNumConta() {
        return this.numConta;
    }

    //tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    //dono
    public void setDono(String dono) {
        this.dono = dono;
    }

    public String getDono() {
        return dono;
    }

    //saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    //status
    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

// metodos personalizados

    //abrir conta
    public void abrirConta(String modalidade) {
        this.setTipo(modalidade);
        this.setStatus(true);
        if (modalidade.equals("CC")) {
            this.setSaldo(50);
        } else if (modalidade.equals("CP")) {
            this.setSaldo(50);
        }
        System.out.println("Conta Aberta com sucesso!");
    }

    //fechar conta
    public void fecharConta() {
        if (this.getSaldo() > 0) {
            System.out.println("Conta não pode ser fechada pois ainda ha saldo");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta não pode ser fechada pois há debito");
        } else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    //depositar
    @Override
    public void depositar(double valor) {
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + valor);
            System.out.println("Deposito realizado na conta de: " + this.getDono());
        } else {
            System.out.println("Inpossivel efetuar deposito em conta fechada");
        }
    }

    //sacar
    @Override
    public void sacar(double valor) {
        if (this.getStatus()) {
            if (this.getSaldo() >= valor) {
                this.setSaldo(this.getSaldo() - valor);
                System.out.println("Saque realizado na conta de " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        } else {
            System.out.println("Impossivel sacar de uma conta fechada");
        }
    }

    //mensalidade
    public void pagarMensal() {
        double valor = 0;
        if (this.tipo.equals("CC")) {
            valor = 12;
        } else if (this.tipo.equals("CP")) {
            valor = 20;
        }
        if (this.status) {
            if (this.saldo >= valor) {
                System.out.println("Mensalidade de: " + valor);
                this.saldo = this.saldo - valor;
                System.out.println("Mensalidade de R$ " + valor + "paga por " + this.dono);
                System.out.println("Saldo atual de: " + this.saldo);
            } else {
                System.out.println("Saldo insuficiente para pagaer mensalidade");
            }
        } else{
            System.out.println("Impossível pagar mensalidade de uma conta fechada.");
        }
    }


    @Override
    public void consultarSaldo() {
        if (this.status){
            System.out.println("Seu saldo atual é: " + this.saldo);
        }else {
            System.out.println("Conta inativa, saldo não disponivel");
        }
    }
}
