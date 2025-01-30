package pl.gamedia.task.domain.entities;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRateDto {

    private BigDecimal rate;
    private int amount;
    private BigDecimal result;
    private BigDecimal fee;

}
