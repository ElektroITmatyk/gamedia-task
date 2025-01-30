package pl.gamedia.task.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gamedia.task.domain.entities.*;
import pl.gamedia.task.infrastructure.adapters.rest.CryptocurrencyPriceAdapter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {

    private static final BigDecimal FEE = new BigDecimal("0.01");
    private final CryptocurrencyPriceAdapter cryptocurrencyPriceAdapter;
    private final CryptocurrencyPriceMapper cryptocurrencyPriceMapper;

    @Override
    public CryptocurrencyPriceResponseDto getPrices(String currency, List<String> filter) {
        CoinlayerLiveResponseDto liveRates = cryptocurrencyPriceAdapter.getLiveRates(currency, filter);
        return cryptocurrencyPriceMapper.map(liveRates);
    }

    @Override
    public CryptocurrencyExchangeResponseDto exchange(CryptocurrencyExchangeRequestDto exchangeRequestDto) {
        CoinlayerLiveResponseDto liveRates = cryptocurrencyPriceAdapter.getLiveRates(exchangeRequestDto.getFrom(), exchangeRequestDto.getTo());

        Map<String, ExchangeRateDto> exchangeRates = new HashMap<>();
        liveRates.getRates()
                 .entrySet()
                 .stream()
                 .forEach(rate -> exchangeRates.put(rate.getKey(), ExchangeRateDto.builder()
                                                                   .amount(exchangeRequestDto.getAmount())
                                                                   .rate(rate.getValue())
                                                                   .result(FEE.multiply(rate.getValue()).multiply(BigDecimal.valueOf(exchangeRequestDto.getAmount())))
                                                                   .fee(FEE)
                                                                   .build()));

        return CryptocurrencyExchangeResponseDto.builder()
                                                .from(exchangeRequestDto.getFrom())
                                                .exchangeRates(exchangeRates)
                                                .build();
    }

}
