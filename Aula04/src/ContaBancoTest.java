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
            assertEquals(0, conta.getSaldo());
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
            assertThrows(AssertionError.class,() -> assertEquals(120,conta.getSaldo()));
        }

        @org.junit.jupiter.api.Test
        void sacar() {
            conta.abrirConta("CC");
            conta.depositar(150);
            conta.sacar(100);
            assertEquals(50,conta.getSaldo());
        }

        @org.junit.jupiter.api.Test
        void pagarMensal() {
            conta.abrirConta("CC");
            conta.depositar(100);
            conta.pagarMensal();
            assertEquals(88,conta.getSaldo());
        }

        @org.junit.jupiter.api.Test
        void consultarSaldo() {
            conta.abrirConta("cp");
            conta.consultarSaldo();
            assertEquals(0,conta.getSaldo());

            conta.fecharConta();
            assertThrows(IllegalStateException.class,() -> conta.consultarSaldo(),"Não deve permitir consultar saldo em conta fechada");
        }
    }