package pl.gamedia.task.infrastructure.adapters.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.gamedia.task.domain.entities.CoinlayerLiveResponseDto;

@FeignClient(value = "coinlayer", url = "${api.coinlayer.url}")
public interface CoinlayerFeignClient {

    @GetMapping
    CoinlayerLiveResponseDto getLiveRates(@RequestParam("access_key") String apiKey, @RequestParam("target") String target, @RequestParam("symbols") String symbols);

}
