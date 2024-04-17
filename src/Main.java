import Services.ApiService.ApiService;
import Services.ApiService.dtos.BaseRates;
import Services.CurrencyService.CurrencyService;
import Services.InputService.InputService;
import Services.InputService.dtos.ExchangeOptions;
import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String API_KEY = dotenv.get("API_KEY");
        ApiService client = new ApiService(API_KEY);
        InputService ioHandler = new InputService();
        CurrencyService currencies = new CurrencyService();

        try {
            ExchangeOptions io = ioHandler.options();
            String base = io.currencies().getFirst();
            String exchange = io.currencies().getLast();
            BaseRates res = client.ApiGetRequest(base);
            Double exchangeRate = res
                    .rates()
                    .getCurr()
                    .get(exchange);
            Double converted = currencies.convert(io.amount(), exchangeRate);

            String message = io.amount() + " " + base + " equivalem a: " + converted + " " + exchange;

            System.out.println(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}