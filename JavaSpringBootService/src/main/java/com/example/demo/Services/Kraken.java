package com.example.demo.Services;

import com.example.demo.DataSource.PostgresDataSource;
import com.example.demo.Models.Ticker;
import com.example.demo.dao.TickerDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Service
public class Kraken {

    private static String SourceAPIBaseURL = "https://api.kraken.com/0/public/";

    //List of few PairNames as example
    private static List<String> PariNames = Arrays.asList("XBTUSD", "BTCEUR", "LTCEUR", "ETHEUR");


    private static TickerService tickerService;

    @Autowired
    public Kraken(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    //Executing GET method on "https://api.kraken.com/0/public/Ticker"
    public static int GetTickerInformation(){
        Ticker ticker;
        try {
            for(String pair: PariNames) {
                ticker = new Ticker();
                ticker.PairName = pair;
                ticker.Data = RestAPIWrapper.GET(SourceAPIBaseURL+"Ticker?pair="+pair);
                ticker.CreationTime = new Timestamp(
                        System.currentTimeMillis()).toString().replace(' ', '_');
                MemoryDataBaseService.Insert(ticker);
                tickerService.Insert(ticker);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 1;
    }



}
