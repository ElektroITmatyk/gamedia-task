package pl.gamedia.task.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.gamedia.task.domain.entities.CoinlayerLiveResponseDto;
import pl.gamedia.task.domain.entities.CryptocurrencyExchangeRequestDto;
import pl.gamedia.task.domain.entities.CryptocurrencyExchangeResponseDto;
import pl.gamedia.task.domain.entities.ExchangeRateDto;
import pl.gamedia.task.infrastructure.adapters.rest.CryptocurrencyPriceAdapter;

import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private static final BigDecimal FEE = new BigDecimal("0.01");

    private final CryptocurrencyPriceAdapter cryptocurrencyPriceAdapter;
    private final CryptocurrencyPriceMapper cryptocurrencyPriceMapper;

    @Override
    public CryptocurrencyExchangeResponseDto exchange(CryptocurrencyExchangeRequestDto exchangeRequestDto) {
        CoinlayerLiveResponseDto liveRates = cryptocurrencyPriceAdapter.getLiveRates(exchangeRequestDto.getFrom(), exchangeRequestDto.getTo());

        Map<String, ExchangeRateDto> exchangeRates = liveRates.getRates().entrySet().parallelStream().collect(Collectors.toMap(Map.Entry::getKey, entry -> getExchangeRateDto(exchangeRequestDto, entry.getValue())));

        return cryptocurrencyPriceMapper.mapExchangeResponse(exchangeRates, exchangeRequestDto.getFrom());
    }

    private ExchangeRateDto getExchangeRateDto(CryptocurrencyExchangeRequestDto exchangeRequestDto, BigDecimal rate) {
        return ExchangeRateDto.builder()
                              .amount(exchangeRequestDto.getAmount())
                              .rate(rate)
                              .result(BigDecimal.valueOf(exchangeRequestDto.getAmount()).multiply(rate).add(FEE.multiply(rate)))
                              .fee(FEE)
                              .build();
    }

}
