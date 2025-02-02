package pl.gamedia.task.domain.service;

import pl.gamedia.task.domain.entities.CryptocurrencyExchangeRequestDto;
import pl.gamedia.task.domain.entities.CryptocurrencyExchangeResponseDto;

public interface ExchangeService {

    CryptocurrencyExchangeResponseDto exchange(CryptocurrencyExchangeRequestDto exchangeRequestDto);

}
