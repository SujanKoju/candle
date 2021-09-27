package com.example.candle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author kojusujan1111@gmail.com 27/09/21
 */

public class CandleService {
    public static List<CandleSeriesData> data = new ArrayList<>();

    public CandleService() {
        Random rand = new Random();
        for (int i = 0; i < 50; i++) // INSERTING 10 Dummy data
        {
            data.add(new CandleSeriesData(LocalDateTime.now().minusMinutes(15 * i), "USD", rand.nextFloat() * 100));
        }

    }

    public List<CandleDto> getCandles(String symbol, LocalDateTime startDate, LocalDateTime endDate, int granularity) {
        List<CandleDto> candleDtos = new ArrayList<>();
        LocalDateTime time1 = startDate;
        LocalDateTime time2 = startDate.plusSeconds(granularity);
        while (time2.isBefore(endDate)) {
            System.out.println(" ---- FROM " + time1 + " " + time2 + " ---- ");
            List<CandleSeriesData> dataWithInCertainFrequency = new ArrayList<>();
            for (CandleSeriesData candleData : data) {
                if (candleData.getTime().isAfter(time1)
                        && candleData.getTime().isBefore(time2)
                        && symbol.equalsIgnoreCase(candleData.getSymbol())) {
                    dataWithInCertainFrequency.add(candleData);
                }
            }
            CandleDto candleDto = prepareCandleDtoFromDataOfThatFrequency(dataWithInCertainFrequency);
            candleDtos.add(candleDto);
            System.out.println(dataWithInCertainFrequency);
            time1 = time1.plusSeconds(granularity);
            time2 = time2.plusSeconds(granularity);
        }
        return candleDtos;
    }

    private CandleDto prepareCandleDtoFromDataOfThatFrequency(List<CandleSeriesData> dataWithInCertainFrequency) {
        CandleDto candleDto = new CandleDto();
        dataWithInCertainFrequency.sort(Comparator.comparing(CandleSeriesData::getPrice));
        candleDto.setLow(dataWithInCertainFrequency.get(0).getPrice());
        candleDto.setHigh(dataWithInCertainFrequency.get(dataWithInCertainFrequency.size() - 1).getPrice());
        dataWithInCertainFrequency.sort(Comparator.comparing(CandleSeriesData::getTime));
        candleDto.setOpen(dataWithInCertainFrequency.get(0).getPrice());
        candleDto.setClose(dataWithInCertainFrequency.get(dataWithInCertainFrequency.size() - 1).getPrice());
        candleDto.setVolume(prepareVolume());
        return candleDto;
    }

    private double prepareVolume() {
        Random rand = new Random();
        return rand.nextFloat();
    }
}
