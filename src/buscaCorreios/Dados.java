package buscaCorreios;

/**
 * Created by lramosduarte on 24/07/16.
 */
public class Dados {

    int cep;
    public String cidade;
    public String bairro;
    public String logradouro;
    public String estado;

    public void setLocalidade(String logradouro){
        cidade = logradouro.split("/")[0].trim();
        estado = logradouro.split("/")[1].trim();
    }
}
