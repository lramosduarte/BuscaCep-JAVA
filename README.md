[![Build Status](https://travis-ci.org/lramosduarte/BuscaCep-JAVA.svg?branch=master)](https://travis-ci.org/lramosduarte/BuscaCep-JAVA)

# BuscaCep-JAVA
Procura os dados de um cep diretamente no site dos correios

**Utilizado apenas standard lib do JAVA 8.**

Requerimentos:
- Java 8
- Gradle

Para realizar a build manualmente:

1. Instale o gradle
1. gradle tasks
1. gradle assemble
1. gradle build

Exemplo de uso:

    import buscaCorreios.dados.Dados.</p>
    import buscaCorreios.services.Pesquisa</p>
    public static void main(String[] args) {
        services.Pesquisa pesquisarCep = new services.Pesquisa();
        dados.Dados resultado = pesquisarCep.buscarCep("39400500");
    }

A ideia inicial era realizar o uso dos iterators no java e fazer um parse de html sem dependencias externas, utilizei como base o projeto:
https://github.com/mbodock/django-cepfield
