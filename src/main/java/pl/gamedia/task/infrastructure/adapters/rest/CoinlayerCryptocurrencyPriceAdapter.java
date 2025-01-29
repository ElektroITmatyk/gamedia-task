package pl.gamedia.task.infrastructure.adapters.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.gamedia.task.domain.entities.CoinlayerLiveResponseDto;
import pl.gamedia.task.infrastructure.adapters.configuration.CoinlayerConfiguration;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CoinlayerCryptocurrencyPriceAdapter implements CryptocurrencyPriceAdapter {

    private final CoinlayerConfiguration coinlayerConfiguration;
    private final CoinlayerFeignClient coinlayerFeignClient;

    @Override
    public CoinlayerLiveResponseDto getLiveRates(String target, List<String> symbols) {
        return coinlayerFeignClient.getLiveRates(coinlayerConfiguration.getApiKey(), target, String.join(",", Optional.ofNullable(symbols).orElse(List.of())));
    }

}
