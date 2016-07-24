package buscaCorreios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lramosduarte on 24/07/16.
 */
public class HtmlParser {
    private final static Pattern TAG = Pattern.compile("<span " +
            "class=\"respostadestaque\">(.+?)</span>");

    private Dados dados;

    public HtmlParser() {
        this.dados = new Dados();
    }

    public Dados parser(StringBuffer html){
        Matcher regex = TAG.matcher(html);
        while(regex.find()){
            extrairDados(regex.group(1));
        }
        return dados;
    }
}
