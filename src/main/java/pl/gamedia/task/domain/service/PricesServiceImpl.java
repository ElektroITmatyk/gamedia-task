package pl.gamedia.task.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gamedia.task.domain.entities.CoinlayerLiveResponseDto;
import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponseDto;
import pl.gamedia.task.infrastructure.adapters.rest.CryptocurrencyPriceAdapter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService {

    private final CryptocurrencyPriceAdapter cryptocurrencyPriceAdapter;
    private final CryptocurrencyPriceMapper cryptocurrencyPriceMapper;

    @Override
    public CryptocurrencyPriceResponseDto getPrices(String currency, List<String> filter) {
        CoinlayerLiveResponseDto liveRates = cryptocurrencyPriceAdapter.getLiveRates(currency, filter);
        return cryptocurrencyPriceMapper.map(liveRates);
    }

}
