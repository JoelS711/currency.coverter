package currencyConverter;

import java.util.Map;

public record Currency(String result, Map<String, Double> conversion_rates) {

}
