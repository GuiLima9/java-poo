import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class ContaBancoTest {

    private ContaBanco conta;

    @BeforeEach
    void setUp() {
        conta = new ContaBanco();
        conta.setNumConta(4044);
        conta.setDono("Elinelson");
    }


    @org.junit.jupiter.api.Test
    void abrirConta() {
        conta.abrirConta("CC");
        assertTrue(conta.getStatus());
        assertEquals("CC",conta.getTipo());
        assertEquals(50.00, conta.getSaldo());
    }

    @org.junit.jupiter.api.Test
    void fecharConta() {
        conta.abrirConta("CC");
        conta.setSaldo(0);
        conta.fecharConta();
        assertFalse(conta.getStatus());
    }

    @org.junit.jupiter.api.Test
    void depositar() {
        conta.abrirConta("CP");
        conta.depositar(1500);
        assertEquals(120,conta.getSaldo());
    }

    @org.junit.jupiter.api.Test
    void sacar() {
        conta.abrirConta("CC");
        conta.depositar(150);
        conta.sacar(100);
        assertEquals(100,conta.getSaldo());
    }

    @org.junit.jupiter.api.Test
    void pagarMensal() {

    }

    @org.junit.jupiter.api.Test
    void consultarSaldo() {

    }
}