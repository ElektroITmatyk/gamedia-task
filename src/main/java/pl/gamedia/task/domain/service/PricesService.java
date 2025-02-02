package pl.gamedia.task.domain.service;

import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponseDto;

import java.util.List;

public interface PricesService {

    CryptocurrencyPriceResponseDto getPrices(String currency, List<String> filter);

}
