package pl.gamedia.task.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptocurrencyPriceResponseDto {

    private String source;
    private Map<String, BigDecimal> rates;

}
