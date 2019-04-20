package services;

import java.io.IOException;

public interface HTTPRequest<RequestReturn, ResponseReturn> {

    RequestReturn request(String cep) throws IOException;
    ResponseReturn response() throws IOException;

}
