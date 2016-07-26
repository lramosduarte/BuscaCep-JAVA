#Utilizado apenas standard lib do JAVA 8.
## BuscaCep-JAVA
Procura os dados de um cep diretamente no site dos correios.

###Exemplo de uso:
<p>import buscaCorreios.Dados.</p>
<p>import buscaCorreios.Pesquisa</p>


    public static void main(String[] args) {
        Pesquisa pesquisarCep = new Pesquisa();
        Dados resultado = pesquisarCep.buscarCep("39400500");
    }

A ideia inicial era realizar o uso dos iterators no java e fazer um parse de html sem dependencias externas, utilizei como base o projeto:
https://github.com/mbodock/django-cepfield
