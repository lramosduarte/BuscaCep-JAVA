import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import dados.Dados;
import services.Pesquisa;


/**
 * Created by sisqualis on 29/07/16.
 */
public class TestPesquisa {

    private Pesquisa pesquisa;

    @Before
    public void setup() throws IOException {
        pesquisa = new Pesquisa();
    }

    @Test
    public void testPesquisa(){
        assertNotNull(pesquisa);
    }

    @Test
    public void testPesquisaInstance(){
        assertThat(pesquisa, instanceOf(Pesquisa.class));
    }

    @Test
    public void testBuscaDadosValidos() throws IOException {
        Dados dados = pesquisa.buscarCep("39400500");
        assertEquals(dados.cidade, "Montes Claros");
    }

    @Test
    public void testBuscaDadosInvalidos() throws IOException {
        Dados dados = pesquisa.buscarCep("12");
        assertNull(dados.cidade);
        assertNull(dados.cidade);
    }

    @Test
    public void testBuscaDadosNulosVazios() throws IOException {
        assertNull(pesquisa.buscarCep(null));
        assertNull(pesquisa.buscarCep(""));
    }
}
