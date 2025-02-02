package pl.gamedia.task.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.gamedia.task.domain.entities.CoinlayerLiveResponseDto;
import pl.gamedia.task.domain.entities.CryptocurrencyExchangeRequestDto;
import pl.gamedia.task.domain.entities.CryptocurrencyExchangeResponseDto;
import pl.gamedia.task.infrastructure.adapters.rest.CryptocurrencyPriceAdapter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExchangeServiceImplTest {

    @InjectMocks
    private ExchangeServiceImpl exchangeService;

    @Mock
    private CryptocurrencyPriceAdapter cryptocurrencyPriceAdapter;

    @Test
    void givenRequestShouldReturnExpectedPrognosisExchange() {
        CryptocurrencyExchangeRequestDto givenRequest = CryptocurrencyExchangeRequestDto.builder()
                                                                                        .to(List.of("BTC", "DOGE", "ABC", "ACP", "ADA", "AIDOC"))
                                                                                        .amount(121)
                                                                                        .from("ETH")
                                                                                        .build();

        when(cryptocurrencyPriceAdapter.getLiveRates(anyString(), anyList())).thenReturn(CoinlayerLiveResponseDto.builder()
                                                                                                 .success(true)
                                                                                                 .terms("https://coinlayer.com/terms")
                                                                                                 .privacy("https://coinlayer.com/privacy")
                                                                                                 .timestamp(1738431726)
                                                                                                 .target(givenRequest.getFrom())
                                                                                                 .rates(getRates())
                                                                                                 .build());

        CryptocurrencyExchangeResponseDto result = exchangeService.exchange(givenRequest);

        assertEquals(givenRequest.getFrom(), result.getFrom());
        assertEquals(givenRequest.getTo().size(), result.getExchangeRates().size());
        assertEquals(3870.04247079, result.getExchangeRates().get("BTC").getResult().doubleValue());
    }

    @BeforeEach
    void setUp() {
        exchangeService = new ExchangeServiceImpl(cryptocurrencyPriceAdapter, new CryptocurrencyPriceMapperImpl());
    }

    private Map<String, BigDecimal> getRates() {
        Map<String, BigDecimal> rates = new HashMap<>();
        rates.put("BTC", BigDecimal.valueOf(31.981179));
        rates.put("DOGE", BigDecimal.valueOf(0.00009718803660456773));
        rates.put("ABC", BigDecimal.valueOf(0.019214));
        rates.put("ACP", BigDecimal.valueOf(0.000004782273334316828));
        rates.put("ADA", BigDecimal.valueOf(0.000286));
        rates.put("AIDOC", BigDecimal.valueOf(0.00000137693837720795));
        return rates;
    }

}