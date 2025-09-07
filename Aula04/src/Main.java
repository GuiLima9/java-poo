public class Main {
    public static void main(String[] args) {
        ContaBanco p1 = new ContaBanco();
        p1.setNumConta(1111);
        p1.setDono("Elinelson");
        p1.abrirConta("CC");
        p1.depositar(100);
        p1.sacar(25);
        p1.estadoAtual();


        /*ContaBanco p2 = new ContaBanco();
        p2.setNumConta(22222);
        p2.setDono("Smiriana");
        p2.abrirConta("CP");
        p2.depositar(500);
        p2.consultarSaldo();
        p2.estadoAtual();*/
    }
}