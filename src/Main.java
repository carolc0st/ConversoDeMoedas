import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner digitar = new Scanner(System.in);
        System.out.println("");

        int opcao = 0;
        double valorEntrada = 0;

        while (opcao != 7) {

            System.out.println("""
                    Seja bem-vindo/a ao conversor de moedas
                                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> EURO
                    4) EURO =>> Dólar
                    5) Dólar =>> Real
                    6) Real =>> Dólar
                    7) Sair
                    Escolha uma opção válida: 
                    """);
            opcao = digitar.nextInt();

            ExchangeRateApi exchangeRateApi = new ExchangeRateApi();

            if (opcao != 7) {
                System.out.println("Digite o valor:");
                valorEntrada = digitar.nextDouble();
                exchangeRateApi.EscolhaAlternativa(opcao, valorEntrada);
            }
        }
        System.out.println("Programa Encerrado.");
    }
}