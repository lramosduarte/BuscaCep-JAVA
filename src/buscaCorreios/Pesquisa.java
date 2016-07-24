package buscaCorreios;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by lramosduarte on 23/07/16.
 */
public class Pesquisa {
    private final String USER_AGENT = "Mozilla/5.0";
    private final String URL = "http://m.correios.com.br/movel/buscaCepConfirma.do");

    private URL resource = new URL(URL);;
    private HttpsURLConnection request;

    public Pesquisa() throws IOException {
        request = (HttpsURLConnection) resource.openConnection();
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

    private int post(String cep) throws IOException {
        request.setDoOutput(true);
        parametros(cep);
        return request.getResponseCode();;
    }

}
