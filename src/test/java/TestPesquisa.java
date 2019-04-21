import java.io.IOException;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dados.Endereco;
import services.Pesquisa;


/**
 * Created by sisqualis on 29/07/16.
 */
public class TestPesquisa {

    static Pesquisa pesquisa;

    @BeforeAll
    static void setup() throws IOException {
        TestPesquisa.pesquisa = new Pesquisa();
    }

    @Test
    void testPesquisa(){
        Assertions.assertNotNull(pesquisa);
    }

    @Test
    void testPesquisaInstance(){
        MatcherAssert.assertThat(pesquisa, CoreMatchers.instanceOf(Pesquisa.class));
    }

    @Test
    void testBuscaDadosValidos() throws IOException {
        Endereco endereco = pesquisa.buscarCep("39400500");
        Assertions.assertEquals(endereco.cidade, "Montes Claros");
    }

    @Test
    void testBuscacepInvalido_retornaNull() throws IOException {
        Endereco endereco = pesquisa.buscarCep("12");
        Assertions.assertNull(endereco);
    }

    @Test
    void testBuscaCepNull_retornaNull() throws IOException {
        Assertions.assertNull(pesquisa.buscarCep(null));
    }

    @Test
    void testBuscaCepVazio_retornaNull() throws IOException {
        Assertions.assertNull(pesquisa.buscarCep(""));
    }
}
