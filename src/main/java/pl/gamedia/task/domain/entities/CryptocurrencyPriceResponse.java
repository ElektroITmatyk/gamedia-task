package pl.gamedia.task.domain.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptocurrencyPriceResponse {

    private String source;
    private Map<String, BigDecimal> rates;

}
