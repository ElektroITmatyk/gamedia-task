package pl.gamedia.task.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoinlayerLiveResponseDto {

    private boolean success;
    private String terms;
    private String privacy;
    private long timestamp;
    private String target;
    private Map<String, Double> rates;

}
