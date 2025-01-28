package pl.gamedia.task.infrastructure.adapters.rest;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "coinlayer", url = "${api.coinlayer.url}")
public interface CoinlayerFeignClient {

    

}
