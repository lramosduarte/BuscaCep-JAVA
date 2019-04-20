package parsers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dados.Endereco;


public class HtmlParser implements Parser<StringBuffer> {
    private final static Pattern TABELA = Pattern.compile(
        "<table class=\"tmptabela\">(.+)<\\/table>");
    private final static Pattern DADOS = Pattern.compile(
        "<td width=.+>(?<logradouro>[a-zA-Z].+)<\\/td>" +
        "<td>(?<bairro>[a-zA-Z].+)<\\/td>" +
        "<td>(?<cidadeEstado>[a-zA-Z].+)<\\/td>" +
        "<td width=.+>(?<cep>[0-9]{5}-[0-9]{3})<\\/td>");

    @Override
    public Endereco parser(StringBuffer html){
        Matcher regexTabela = this.TABELA.matcher(html);
        if(!regexTabela.find()) {
            return null;
        }
        Matcher regexDados = this.DADOS.matcher(regexTabela.group(1));
        regexDados.find();
        return extrairDados(regexDados);
    }

    private Endereco extrairDados(Matcher result) {
        Endereco endereco = new Endereco();
        endereco.logradouro = this.limpaDado(result.group("logradouro"));
        endereco.bairro = this.limpaDado(result.group("bairro"));
        endereco.cep = this.limpaDado(result.group("cep"));
        String[] cidadeEstado = result.group("cidadeEstado").split("/");
        endereco.cidade = this.limpaDado(cidadeEstado[0]);
        endereco.estado = this.limpaDado(cidadeEstado[1]);
        return endereco;
    }

    private String limpaDado(String dado) {
        return dado.replaceAll("&nbsp;", "").trim();
    }

}
