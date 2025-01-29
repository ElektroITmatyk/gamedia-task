package pl.gamedia.task.infrastructure.adapters.rest;

import pl.gamedia.task.domain.entities.CoinlayerLiveResponseDto;

import java.util.List;

public interface CryptocurrencyPriceAdapter {

    CoinlayerLiveResponseDto getLiveRates(String target, List<String> symbols);

}
