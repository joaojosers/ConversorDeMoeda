package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaMoeda {

    public static void executaConsulta(String moedaBase, String moedaDestino, double valor) {
        Dotenv dotenv = Dotenv.load(); // Carrega a chave do .env
        String apiKey = dotenv.get("API_KEY");

        if (apiKey == null) {
            System.out.println("API KEY não configurada.");
            return;
        }

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Erro na requisição: " + response.statusCode());
                return;
            }

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);

            String atualizacao = json.get("time_last_update_utc").getAsString();
            JsonObject taxas = json.getAsJsonObject("conversion_rates");
            double taxa = taxas.get(moedaDestino).getAsDouble();

            double valorConvertido = valor * taxa;

            System.out.println("Última atualização: " + atualizacao);
            System.out.printf(Locale.US, "Valor %.2f [%s] corresponde ao valor final de =>>> %.8f [%s]%n",
                    valor, moedaBase, valorConvertido, moedaDestino);


            System.out.println("************************");

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao consultar a API: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Moeda de destino não encontrada na resposta.");
        }
    }
}


