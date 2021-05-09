package com.example.demo.Services;

import com.example.demo.Models.Ticker;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class Kraken {

    private static String SourceAPIBaseURL = "https://api.kraken.com/0/public/";

    //List of few PairNames as example
    private static List<String> PariNames = Arrays.asList("XBTUSD", "BTCEUR", "LTCEUR", "ETHEUR");

    //Executing GET method on "https://api.kraken.com/0/public/Ticker"
    public static int GetTickerInformation(){
        Ticker ticker;
        try {
            for(String pair: PariNames) {
                ticker = new Ticker();
                ticker.PairName = pair;
                ticker.Data = RestAPIWrapper.GET("https://api.kraken.com/0/public/Ticker?pair="+pair);
                ticker.CreationTime = new Timestamp(
                        System.currentTimeMillis()).toString().replace(' ', '_');
                MemoryDataBaseService.Insert(ticker);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }



}
