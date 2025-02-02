package pl.gamedia.task.domain.entities;

import lombok.*;

import java.math.BigDecimal;
import java.util.Map;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoinlayerLiveResponseDto {

    private boolean success;
    private String terms;
    private String privacy;
    private long timestamp;
    private String target;
    private Map<String, BigDecimal> rates;

}
