package Services.InputService;

import Services.InputService.dtos.ExchangeOptions;

import java.util.*;

public class InputService {
    public enum bases {
        ARS, BOB, BRL, CLP, COP, USD
    }
    public String greet = """
                ********************************************
                  Seja bem-vindo/a ao Conversor de Moeda =]
                ********************************************
                """;
    public String currencies = """
                Insira o número da moeda que deseja selecionar:

                    1) ARS -> Peso Argentino
                    2) BOB -> Boliviano boliviano
                    3) BRL -> Real brasileiro
                    4) CLP -> Peso chileno
                    5) COP -> Peso colombiano
                    6) USD -> Dólar americano
                """;
    public ExchangeOptions options() {
        System.out.println(this.greet);

        System.out.println("Selecione a moeda de Base");
        int base = baseSetter();

        System.out.println("Selecione a moeda para qual deseja converter");
        int exchange = baseSetter();

        double amount = valueSetter();

        List<String> parseExchange = exchangeSetter(base, exchange);
        return new ExchangeOptions(parseExchange, amount);
    }

    public int baseSetter() {
        int min = 1;
        int max = bases.values().length;
        System.out.println(this.currencies);
        try {
            Scanner scanner = new Scanner(System.in);
            int base = scanner.nextInt();

            if (base < min || base > max) {
                throw new InputMismatchException();
            }

            return base;
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida, insira um número de " + min + " a " + max);
            return this.baseSetter();
        }
    }

    public List<String> exchangeSetter(int base, int exchange) {
        Map<Integer, String> currency = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(bases.ARS.ordinal(), "ARS"),
            new AbstractMap.SimpleEntry<>(bases.BOB.ordinal(), "BOB"),
            new AbstractMap.SimpleEntry<>(bases.BRL.ordinal(), "BRL"),
            new AbstractMap.SimpleEntry<>(bases.CLP.ordinal(), "CLP"),
            new AbstractMap.SimpleEntry<>(bases.COP.ordinal(), "COP"),
            new AbstractMap.SimpleEntry<>(bases.USD.ordinal(), "USD")
        );

        String baseCurrency = currency.get(base - 1);
        String exchangeCurrency = currency.get(exchange - 1);

        return List.of(baseCurrency, exchangeCurrency);
    }

    public double valueSetter() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Insira a quantidade:");
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um número no formato 00.00 com '.' ao invés de ','");
            return this.valueSetter();
        }
    }
}
