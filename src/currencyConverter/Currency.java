package currencyConverter;

import java.util.Map;

public record Currency(String result,String base_code, Map<String, Double> conversion_rates) {

}
