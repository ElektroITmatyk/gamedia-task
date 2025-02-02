package pl.gamedia.task.domain.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CryptocurrencyExchangeRequestDto {

    private String from;
    private List<String> to;
    private int amount;

}
