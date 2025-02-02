package pl.gamedia.task.application.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gamedia.task.domain.entities.CryptocurrencyExchangeRequestDto;
import pl.gamedia.task.domain.entities.CryptocurrencyExchangeResponseDto;
import pl.gamedia.task.domain.entities.CryptocurrencyPriceResponseDto;
import pl.gamedia.task.domain.service.ExchangeService;
import pl.gamedia.task.domain.service.PricesService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currencies")
public class CryptocurrencyController {

    private final PricesService pricesService;
    private final ExchangeService exchangeService;

    @GetMapping("/{currency}")
    public ResponseEntity<CryptocurrencyPriceResponseDto> getPrices(@PathVariable("currency") String currency, @RequestParam(value = "filter", required = false) List<String> filter) {
        return ResponseEntity.ok(pricesService.getPrices(currency, filter));
    }

    @PostMapping("/exchange")
    public ResponseEntity<CryptocurrencyExchangeResponseDto> exchange(@RequestBody CryptocurrencyExchangeRequestDto exchangeRequestDto) {
        return ResponseEntity.ok(exchangeService.exchange(exchangeRequestDto));
    }

}
