package buscaCorreios;

/**
 * Created by lramosduarte on 24/07/16.
 */
public class Dados {

    int cep;
    String cidade;
    String bairro;
    String logradouro;
    String estado;

    public void setLocalidade(String logradouro){
        cidade = logradouro.split("/")[0];
        estado = logradouro.split("/")[1];
    }
}
