package buscaCorreios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lramosduarte on 24/07/16.
 */
public class HtmlParser {
    private final static Pattern TAG_NOMES = Pattern.compile("<span " +
            "class=\"resposta\">(.+?)</span>");
    private final static Pattern TAG = Pattern.compile("<span " +
            "class=\"respostadestaque\">(.+?)</span>");

    private Dados dados;

    public HtmlParser() {
        this.dados = new Dados();
    }

    public Dados parser(StringBuffer html){
        Iterator<String> nomes = nomeTags(html).iterator();
        Iterator<String> valores = valoresTags(html).iterator();
        while(nomes.hasNext() && valores.hasNext()){
            extrairDados(nomes.next(), valores.next());
        }
        return dados;
    }

    private void extrairDados(String nome, String valor) {
        switch (nome){
            case "Logradouro: ":
                dados.logradouro = valor;
                break;
            case "Bairro: ":
                dados.bairro = valor;
                break;
            case "CEP: ":
                dados.cep = Integer.parseInt(valor);
                break;
            default:
                dados.setLocalidade(valor);
                break;
        }
    }

    private List nomeTags(StringBuffer html){
        List<String> nomes = new ArrayList<>();
        Matcher regex = TAG_NOMES.matcher(html);
        while (regex.find())
            nomes.add(regex.group(1));
        return nomes;
    }

    private List valoresTags(StringBuffer html){
        List<String> valores = new ArrayList<>();
        Matcher regex = TAG.matcher(html);
        while (regex.find())
            valores.add(regex.group(1));
        return valores;
    }
 }
