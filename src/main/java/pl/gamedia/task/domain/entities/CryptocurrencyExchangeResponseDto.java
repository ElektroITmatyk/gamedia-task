package pl.gamedia.task.domain.entities;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CryptocurrencyExchangeResponseDto {

    private String from;
    private Map<String, ExchangeRateDto> exchangeRates;

}
