package com.example.candle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class CandleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandleApplication.class, args);


        CandleService candleService = new CandleService();
        List<CandleDto> candles = candleService.getCandles("USD", LocalDateTime.now().minusHours(5), LocalDateTime.now(), 3600);

        System.out.println("DONE");

    }

}
