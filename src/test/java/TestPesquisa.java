package test.java;

import buscaCorreios.Dados;
import buscaCorreios.Pesquisa;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.IOException;


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

    @Test
    public void testStatusCode() throws IOException {
        pesquisa.buscarCep("39400500");
        assertEquals(pesquisa.getStatus(), 200);
    }


}
