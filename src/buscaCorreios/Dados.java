package buscaCorreios;

/**
 * Created by lramosduarte on 24/07/16.
 */
public class Dados {

    int cep;
    String cidade;
    String bairro;
    String localidade;
    String estado;

    public void setLogradouro(String logradouro){
        cidade = logradouro.split("/")[0];
        estado = logradouro.split("/")[1];
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }


}
