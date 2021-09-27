package com.example.candle;

/**
 * @author kojusujan1111@gmail.com 27/09/21
 */

public class CandleDto {
    private long time; //timestamp in millisecond
    private double low; // min price
    private double high; // max price
    private double open; // first price
    private double close; //last price
    private double volume; //total txn amount

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}
