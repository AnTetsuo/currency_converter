package Services.ApiService.dtos;


import java.util.AbstractMap;
import java.util.Map;

public record ConversionRates(
        Double ARS,
        Double BOB,
        Double BRL,
        Double CLP,
        Double COP,
        Double USD
        ) {
        public Map<String, Double> getCurr() {
            return Map.ofEntries(
                new AbstractMap.SimpleEntry<>("ARS", this.ARS()),
                new AbstractMap.SimpleEntry<>("BOB", this.BOB()),
                new AbstractMap.SimpleEntry<>("BRL", this.BRL()),
                new AbstractMap.SimpleEntry<>("CLP", this.CLP()),
                new AbstractMap.SimpleEntry<>("COP", this.COP()),
                new AbstractMap.SimpleEntry<>("USD", this.USD())
                );
        }
}
