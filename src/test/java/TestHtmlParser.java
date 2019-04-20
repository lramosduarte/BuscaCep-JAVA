import dados.Endereco;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parsers.HtmlParser;
import services.Pesquisa;

import java.io.IOException;


public class TestHtmlParser {

    final String CEP = "04531-020";

    StringBuffer response;

    @BeforeEach
    public void setUp() throws IOException {
        this.response = new Pesquisa().request(this.CEP).response();
    }

    @Test
    public void testRecebeHtmlComResultadoValidoApenasUmEndereco_retornaObjetoEndereco() {
        Endereco endereco = new HtmlParser().parser(this.response);
        MatcherAssert.assertThat(endereco, CoreMatchers.instanceOf(Endereco.class));
    }

    @Test
    public void testRecebeHtmlComResultadoValidoApenasUmEndereco_retornaEnderecoComDados() {
        Endereco endereco = new HtmlParser().parser(this.response);
        Assertions.assertEquals(this.CEP, endereco.cep);
    }

    @Test
    public void testRecebeHtmlComResultadoValidoApenasUmEndereco_retornaCidade() {
        Endereco endereco = new HtmlParser().parser(this.response);
        Assertions.assertNotNull(endereco.cidade);
    }

    @Test
    public void testRecebeHtmlComResultadoValidoApenasUmEndereco_retornaEstado() {
        Endereco endereco = new HtmlParser().parser(this.response);
        Assertions.assertNotNull(endereco.estado);
    }

}
