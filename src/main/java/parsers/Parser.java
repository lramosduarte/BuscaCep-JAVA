package parsers;

import dados.Endereco;


public interface Parser<STRINGBUFFER> {

    Endereco parser(STRINGBUFFER buffer);

}
