package pl.gamedia.task.domain.service;

import org.springframework.stereotype.Service;
import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponse;

import java.util.List;

@Service
public class PricesServiceImpl implements PricesService {

    @Override
    public List<CryptocurrencyPriceResponse> getPrices(String currency, List<String> filter) {
        return List.of();
    }

}
