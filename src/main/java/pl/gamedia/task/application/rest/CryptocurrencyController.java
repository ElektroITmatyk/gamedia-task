package pl.gamedia.task.application.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponse;
import pl.gamedia.task.domain.service.PricesService;

import java.util.List;

@RequiredArgsConstructor
@RestController("currencies")
public class CryptocurrencyController {

    private final PricesService pricesService;

    @GetMapping("/{currency}")
    public List<CryptocurrencyPriceResponse> retrievePrices(@PathVariable("currency") String currency, @RequestParam("filter") List<String> filter) {
        return pricesService.getPrices(currency, filter);
    }

}
