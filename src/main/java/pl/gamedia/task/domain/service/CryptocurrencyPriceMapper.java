package pl.gamedia.task.domain.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.gamedia.task.domain.entities.CoinlayerLiveResponseDto;
import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponseDto;

@Mapper(componentModel = "spring")
public interface CryptocurrencyPriceMapper {

    @Mapping(target = "source", source = "coinlayerLiveResponseDto.target")
    CryptocurrencyPriceResponseDto map(CoinlayerLiveResponseDto coinlayerLiveResponseDto);

}
