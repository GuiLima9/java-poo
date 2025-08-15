public class ContaBanco {//atributos
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    public void estadoAtual(){
        System.out.println("Conta: "+ this.getNumConta());
        System.out.println("Tipo: "+ this.getTipo());
        System.out.println("Dono: "+ this.getDono());
        System.out.println("Saldo: "+ this.getSaldo());
        System.out.println("Status:" + this.getStatus());
    }


    //metodos especiais(construtores)

    public ContaBanco(){
        this.saldo = 0;
        this.status = false;
    }



    //numero da conta
    public void setNumConta(int numConta){
        this.numConta = numConta;
    }
    public int getNumConta(){
        return this.numConta;
    }


    //tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo(){
        return tipo;
    }


    //dono
    public void setDono(String dono) {
        this.dono = dono;
    }
    public String getDono(){
        return dono;
    }


    //saldo
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public float getSaldo(){
        return saldo;
    }


    //status
    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean getStatus(){
        return status;
    }








// metodos personalizados


    //abrir conta
    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true);
        if (t == "CC") {
            this.setSaldo(50);
        } else if (t == "CP") {
            this.setSaldo(50);
        }
        System.out.println("Conta Aberta com sucesso!");
    }


    //fechar conta
    public void fecharConta(){
        if (this.getSaldo() > 0){
            System.out.println("Conta não pode ser fechada pois ainda ha saldo");
        } else if (this.getSaldo() < 0) {
            System.out.println("Conta não pode ser fechada pois há debito");
        }else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }


    //depositar
    public void depositar(float v){
        if (this.getStatus()){
            this.setSaldo(this.getSaldo()+v);
            System.out.println("Deposito realizado na conta de: " + this.getDono());
        }else {
            System.out.println("Inpossivel efetuar deposito em conta fechada");
        }
    }


    //sacar
    public void sacar(float v){
        if (this.getStatus()){
            if (this.getSaldo() >= v){
                this.setSaldo(this.getSaldo()  - v);
                System.out.println("Saque realizado na conta de "+ this.getDono());
            }else {
                System.out.println("Saldo insuficiente para saque");
            }
        }else {
            System.out.println("Impossivel sacar de uma conta fechada");
        }
    }


    //mensalidade
    public void pegarMensal(){
        int v = 0;
        if (this.getTipo() == "CC"){
            v = 12;
        } else if (this.getTipo()== "CP") {
            v=20;
        }
        if (this.getStatus()){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Mensalidade paga com sucesso por " + this.getDono());
        }else {
            System.out.println("Impossivel pagar uma conta fechada!");
        }
    }

}
