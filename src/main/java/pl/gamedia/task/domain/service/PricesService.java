package pl.gamedia.task.domain.service;

import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponse;

import java.util.List;

public interface PricesService {

    List<CryptocurrencyPriceResponse> getPrices(String currency, List<String> filter);

}
