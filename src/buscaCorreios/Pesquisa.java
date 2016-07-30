package buscaCorreios;

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
public class Pesquisa {
    private final String USER_AGENT = "Mozilla/5.0";
    private final String URL = "http://m.correios.com.br/movel/" +
            "buscaCepConfirma.do";

    private URL resource = new URL(URL);;
    private HttpURLConnection request;

    public Pesquisa() throws IOException {
        request = (HttpURLConnection) resource.openConnection();
        setCabecalhoRequest("POST");
    }

    private void setCabecalhoRequest(String metodo){
        try {
            request.setRequestMethod(metodo);
        } catch (ProtocolException e) {
            e.printStackTrace();
            return;
        }
        request.setRequestProperty("User-Agent", USER_AGENT);
        request.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    }

    private void parametros(String cep) throws IOException {
        String parametrosUrl = "cepEntrada=" + cep + "&metodo=buscarCep";
        DataOutputStream stream = new DataOutputStream(request
                .getOutputStream());
        stream.writeBytes(parametrosUrl);
        stream.flush();
        stream.close();
    }

    private void sendRequest(String cep) throws IOException {
        request.setDoOutput(true);
        parametros(cep);
        request.getResponseCode();
    }

    private StringBuffer response() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(request.getInputStream(), "ISO-8859-1"));
        String line;
        StringBuffer response = new StringBuffer();
        while ((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();
        return response;
    }

    public Dados buscarCep(String cep){
        try{
            if(cep == null || cep.isEmpty()){
                return null;
            }
            this.sendRequest(cep);
            HtmlParser parser = new HtmlParser();
            Dados dados = parser.parser(response());
            return dados;
        }catch (IOException ex){
            return null;
        }

    }
}
