package services;

import dados.Endereco;
import parsers.HtmlParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;


/**
 * Created by lramosduarte on 23/07/16.
 */
public class Pesquisa implements HTTPRequest<Pesquisa, StringBuffer> {
    public static final int TAMANHO_DEFAULT_CEP = 8;

    private final String USER_AGENT = "Mozilla/5.0";
    private final String URL = "http://www.buscacep.correios.com.br/sistemas/buscacep/" +
        "resultadoBuscaCepEndereco.cfm";

    private URL resource = new URL(URL);;
    private HttpURLConnection request;

    public Pesquisa() throws IOException {
        this.request = (HttpURLConnection) resource.openConnection();
        setCabecalhoRequest();
    }

    private void setCabecalhoRequest() throws ProtocolException {
        this.request.setRequestMethod("POST");
        this.request.setRequestProperty("User-Agent", USER_AGENT);
        this.request.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    }

    private void parametros(String cep) throws IOException {
        String parametrosUrl = "relaxation=" + cep + "&tipoCEP=ALL&semelhante=N";
        DataOutputStream stream = new DataOutputStream(this.request.getOutputStream());
        stream.writeBytes(parametrosUrl);
        stream.flush();
        stream.close();
    }

    @Override
    public Pesquisa request(String cep) throws IOException {
        this.request.setDoOutput(true);
        this.parametros(cep);
        this.request.getResponseCode();
        return this;
    }

    @Override
    public StringBuffer response() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(this.request.getInputStream(), "ISO-8859-1"));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();
        return response;
    }

    public Endereco buscarCep(String cep) throws IOException {
        if(cep == null ||
        cep.isEmpty() ||
        Integer.getInteger(cep) != null ||
        cep.length() != TAMANHO_DEFAULT_CEP){
            return null;
        }
        this.request(cep);
        return new HtmlParser().parser(this.response());
    }
}
