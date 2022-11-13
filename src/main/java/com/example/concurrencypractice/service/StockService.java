package com.example.concurrencypractice.service;

import com.example.concurrencypractice.domain.Stock;
import com.example.concurrencypractice.domain.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(final StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void decrease(final Long id, final Long quantity) {
        final Stock stock = stockRepository.findById(id)
                .orElseThrow();

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
