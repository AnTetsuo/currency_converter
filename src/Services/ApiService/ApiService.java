package Services.ApiService;

import Services.ApiService.exceptions.ApiException;
import com.google.gson.Gson;
import Services.ApiService.dtos.ApiResponse;
import Services.ApiService.dtos.BaseRates;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    public String API_KEY;
    public String base_uri = "https://v6.exchangerate-api.com/v6/";

    public ApiService(
        String apiKey
    ) {
        this.API_KEY = apiKey;
    }

    public BaseRates ApiGetRequest(String base) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest reqBuilder = HttpRequest
                .newBuilder()
                .uri(URI.create(base_uri + API_KEY + "/latest/" + base))
                .build();

        HttpResponse<String> request = client
                .send(reqBuilder, HttpResponse.BodyHandlers.ofString());

        ApiResponse res = new Gson().fromJson(request.body(), ApiResponse.class);

        if (request.statusCode() != 200) {
            throw new ApiException(res.errorType());
        }

        return new BaseRates(res.baseCode(), res.conversionRates());
    }

}
