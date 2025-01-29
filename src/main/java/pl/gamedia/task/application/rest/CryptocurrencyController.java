package pl.gamedia.task.application.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponseDto;
import pl.gamedia.task.domain.service.PricesService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currencies")
public class CryptocurrencyController {

    private final PricesService pricesService;

    @GetMapping("/{currency}")
    public ResponseEntity<CryptocurrencyPriceResponseDto> retrievePrices(@PathVariable("currency") String currency, @RequestParam(value = "filter", required = false) List<String> filter) {
        return ResponseEntity.ok(pricesService.getPrices(currency, filter));
    }

}
