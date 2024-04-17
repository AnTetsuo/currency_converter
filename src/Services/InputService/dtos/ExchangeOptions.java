package Services.InputService.dtos;

import java.util.List;

public record ExchangeOptions(
        List<String> currencies,
        Double amount
) {
}
