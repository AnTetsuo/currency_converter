package Services.ApiService.dtos;

public record BaseRates(
        String base,
        ConversionRates rates
) {
}
