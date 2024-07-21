package com.project.microservices.currency_exchange_service.Controller;
import com.project.microservices.currency_exchange_service.Beans.CurrencyExchange;
import com.project.microservices.currency_exchange_service.Repository.CurrencyExchangeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRespository exchangeRespository;

    @Autowired
    private Environment environment;

    @GetMapping("currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retriveExchangeValue(
            @PathVariable String from,
            @PathVariable String to)

    {
        CurrencyExchange currencyExchange=exchangeRespository.findByFromAndTo(from, to);
        if(currencyExchange==null)
        {
            throw new RuntimeException("Unable to find data in currenc  y exchange");
        }
        String port= environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
