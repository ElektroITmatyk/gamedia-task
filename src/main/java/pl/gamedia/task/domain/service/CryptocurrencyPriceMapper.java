package pl.gamedia.task.domain.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.gamedia.task.domain.entities.CoinlayerLiveResponseDto;
import pl.gamedia.task.domain.entities.CryptocurrencyExchangeResponseDto;
import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponseDto;
import pl.gamedia.task.domain.entities.ExchangeRateDto;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface CryptocurrencyPriceMapper {

    @Mapping(target = "source", source = "coinlayerLiveResponseDto.target")
    CryptocurrencyPriceResponseDto mapPriceResponse(CoinlayerLiveResponseDto coinlayerLiveResponseDto);

    @Mapping(target = "exchangeRates", source= "exchangeRates")
    @Mapping(target = "from", source= "from")
    CryptocurrencyExchangeResponseDto mapExchangeResponse(Map<String, ExchangeRateDto> exchangeRates, String from);

}
