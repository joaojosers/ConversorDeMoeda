# Conversor de Moedas

Este é um conversor de moedas desenvolvido em Java que utiliza a API exchangerate-api.com para converter valor de uma moeda para outra escolhida pelo usuário com base nas taxas de câmbio mais recentes.

## Funcionalidades

O programa oferece as seguintes conversões de moeda:

* Dólar (USD) → Peso Argentino (ARS)
* Peso Argentino (ARS) → Dólar (USD)
* Dólar (USD) → Real Brasileiro (BRL)
* Real Brasileiro (BRL) → Dólar (USD)
* Dólar (USD) → Peso Colombiano (COP)
* Peso Colombiano (COP) → Dólar (USD)

## Pré-requisitos

* **Java Development Kit (JDK):** Certifique-se de ter o JDK instalado no seu sistema.
* **API Key:** Você precisa obter uma chave de API gratuita no site [exchangerate-api.com](https://www.exchangerate-api.com).
* **.env file:** Crie um arquivo `.env` na raiz do projeto e adicione sua chave de API da seguinte forma:

    ```
    API_KEY=SUA_CHAVE_AQUI
    ```
* **Bibliotecas:** O projeto utiliza as seguintes bibliotecas, que podem ser gerenciadas com um sistema de build como Maven ou Gradle, ou adicionadas manualmente ao classpath:
    * [dotenv](https://github.com/cdimascio/java-dotenv) para carregar a chave da API do arquivo `.env`.
    * [Gson](https://github.com/google/gson) para processar a resposta JSON da API.

## Como Executar

1.  **Clone o repositório (ou baixe os arquivos fonte).**
2.  **Configure o arquivo `.env`** com sua chave de API.
3.  **Compile os arquivos Java:**

    ```bash
    javac -cp "lib/*" -d out src/principal/Principal.java src/modelos/*.java
    ```

4.  **Execute o programa:**

    ```bash
    java principal.Principaljava -cp "lib/*:out" principal.Principal
    ```

5.  **Siga as instruções do menu** para realizar as conversões desejadas.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

* `principal/`: Contém a classe `Principal.java`, que é o ponto de entrada do programa.
* `modelos/`: Contém as classes `Menu.java` (responsável por exibir o menu de opções) e `ConsultaMoeda.java` (responsável por realizar a consulta à API e calcular a conversão).

## Classes Principais

* `Principal`:
    * Carrega a chave da API do arquivo `.env`.
    * Chama o método `exibirMenu()` da classe `Menu` para iniciar a interação com o usuário.
* `Menu`:
    * Exibe o menu de opções de conversão para o usuário.
    * Lê a opção escolhida pelo usuário e o valor a ser convertido.
    * Chama o método `executaConsulta()` da classe `ConsultaMoeda` para realizar a conversão.
* `ConsultaMoeda`:
    * Realiza a chamada à API `exchangerate-api.com` para obter a taxa de câmbio.
    * Processa a resposta JSON utilizando a biblioteca Gson.
    * Calcula o valor convertido e exibe o resultado formatado para o usuário.
    * Trata possíveis erros durante a chamada à API ou no processamento da resposta.

## Tratamento de Erros

O programa inclui tratamento básico de erros, como:

* Verificação se a chave da API foi configurada corretamente.
* Tratamento de erros de requisição HTTP (status code diferente de 200).
* Tratamento de exceções de IO e InterruptedException durante a chamada à API.
* Tratamento de NullPointerException caso a moeda de destino não seja encontrada na resposta da API.

## Melhorias Futuras

* Adicionar mais opções de moedas.
* Implementar uma interface gráfica (GUI).
* Persistir o histórico de conversões.
* Melhorar o tratamento de erros e validação de entrada do usuário.


## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias ou correções de bugs.

## Autor

\[João José Rocha de Sousa]
