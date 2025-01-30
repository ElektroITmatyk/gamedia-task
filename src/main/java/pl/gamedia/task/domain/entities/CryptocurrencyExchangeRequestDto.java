package pl.gamedia.task.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CryptocurrencyExchangeRequestDto {

    private String from;
    private List<String> to;
    private int amount;

}
