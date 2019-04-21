[![Build Status](https://travis-ci.org/lramosduarte/BuscaCep-JAVA.svg?branch=master)](https://travis-ci.org/lramosduarte/BuscaCep-JAVA)

# BuscaCep-JAVA
Biblioteca simples para JDK 1.8+ com o minimo de dependências possível afim de ser rápida e leve.

É uma lib simples de se utilizar, sendo necessário informar apenas alguns endereco para a busca de um ou mais endereços.

### Tipos de busca

#### CEP `buscarCep`
Retorna um endereço, caso o cep não seja encontrado será retornado `null`.
Exemplo: 
```java
Endereco endereco = new Pesquisa().buscarCep("39400500");
```
#### Endereço `buscarEndereco` 
**Ainda não implementado**

Retorna uma lista de endereços, caso nenhum endereço seja encontrado a lista estará vazia.
Exemplo:
```java
Set<endereco> endereco = new Pesquisa().buscarEndereco("Rodoviária Tiete");
```

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

```java
import endereco.Endereco;
import services.Pesquisa;
...
    public static void main(String[] args) {
        services.Pesquisa pesquisarCep = new services.Pesquisa();
        endereco.Endereco resultado = pesquisarCep.buscarCep("39400500");
    }
```
