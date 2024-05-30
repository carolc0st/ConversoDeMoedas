import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApi {

    String urlBase = "https://v6.exchangerate-api.com/v6/c06c67f51e6f0a1ace0ede6b/pair/";


    public void EscolhaAlternativa(int opcao, double valor) throws IOException, InterruptedException {
        String cambioEntrada = "";
        String cambioSaida = "";
        switch (opcao){
            case 1 : cambioEntrada = "USD"; cambioSaida = "ARS";
            break;
            case 2 : cambioEntrada = "ARS"; cambioSaida = "USD";
            break;
            case 3 : cambioEntrada = "USD"; cambioSaida = "EUR";
            break;
            case 4 : cambioEntrada = "EUR"; cambioSaida = "USD";
            break;
            case 5 : cambioEntrada = "USD"; cambioSaida = "BRL";
            break;
            case 6 : cambioEntrada = "BRL"; cambioSaida = "USD";
            break;

            default : System.out.println("Escolha uma opção válida!");
            break;
        }

        ExchangeResponse exchangeResponse = Exchange(cambioEntrada, cambioSaida, valor);

        System.out.println("A conversão do valor "  + valor + " de " + cambioEntrada + " para " +
                cambioSaida + " é " + exchangeResponse.conversion_result + " sendo a taxa " + exchangeResponse.conversion_rate );
    }

    private ExchangeResponse Exchange(String cambioEntrada, String cambioSaida, double valor) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlBase + cambioEntrada + "/" + cambioSaida + "/" + valor))
                .build();
        HttpResponse <String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();

        return gson.fromJson(response.body(), ExchangeResponse.class);
    }




//   client.sendAsync(request, BodyHandlers.ofString())
//            .thenApply(HttpResponse::body)
//         .thenAccept(System.out::println)
//         .join();



}
