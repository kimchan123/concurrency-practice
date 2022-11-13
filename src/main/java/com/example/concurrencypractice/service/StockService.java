package com.example.concurrencypractice.service;

import com.example.concurrencypractice.domain.Stock;
import com.example.concurrencypractice.domain.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(final StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    /**
     * @Transactional 동작 방식이 프록시를 사용 트랜잭션을 시작하고 커밋하는 부분까지는 synchronized에 묶이지 않아 비정상적으로 작동.
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void decrease(final Long id, final Long quantity) {
        final Stock stock = stockRepository.findById(id)
                .orElseThrow();

        stock.decrease(quantity);

        stockRepository.saveAndFlush(stock);
    }
}
