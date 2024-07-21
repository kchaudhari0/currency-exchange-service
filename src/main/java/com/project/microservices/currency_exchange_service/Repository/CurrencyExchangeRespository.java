package com.project.microservices.currency_exchange_service.Repository;

import com.project.microservices.currency_exchange_service.Beans.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRespository extends JpaRepository<CurrencyExchange,Long> {

    CurrencyExchange findByFromAndTo(String from, String to);
}
