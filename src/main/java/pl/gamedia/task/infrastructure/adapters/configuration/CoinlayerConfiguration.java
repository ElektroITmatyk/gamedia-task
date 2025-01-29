package pl.gamedia.task.infrastructure.adapters.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class CoinlayerConfiguration {

    @Value("${api.coinlayer.key}")
    private String apiKey;

}
