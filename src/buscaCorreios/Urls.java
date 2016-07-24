package buscaCorreios;

/**
 * Created by lramosduarte on 23/07/16.
 */
public enum Urls {
    CORREIOS("http://m.correios.com.br/movel/buscaCepConfirma.do");

    private final String texto;

    private Urls(final String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return texto;
    }
}