import Services.ApiService.ApiClient;
import Services.InputService.CurrencyIo;
import Services.InputService.dtos.ExchangeOptions;
import io.github.cdimascio.dotenv.Dotenv;

    public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String API_KEY = dotenv.get("API_KEY");
    }
}