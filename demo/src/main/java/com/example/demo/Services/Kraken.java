package com.example.demo.Services;

import com.example.demo.MemoryDB.DataBase;
import com.example.demo.Models.Ticker;

import java.sql.Time;
import java.sql.Timestamp;

public class Kraken {

    private static String SourceAPIBaseURL = "https://api.kraken.com/0/public/";


    //Executing GET method on "https://api.kraken.com/0/public/Ticker"
    public static int GetTickerInformation(){
        Ticker ticker = new Ticker();
        try {
            ticker.Data = RestAPIWrapper.GET("https://api.kraken.com/0/public/Ticker?pair=XBTUSD");
            ticker.creationTime = new Timestamp(System.currentTimeMillis());
            DataBase.insertTicker(ticker);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }



}
