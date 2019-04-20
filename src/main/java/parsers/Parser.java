package parsers;

import dados.Dados;

public interface Parser<STRINGBUFFER> {

    Dados parser(STRINGBUFFER buffer);

}
