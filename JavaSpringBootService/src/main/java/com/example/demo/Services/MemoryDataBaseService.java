package com.example.demo.Services;

import com.example.demo.MemoryDB.DataBase;
import com.example.demo.Models.Ticker;

import java.util.List;
import java.util.stream.Collectors;

public class MemoryDataBaseService {

    private static DataBase DataBase = new DataBase();

    public static void Insert(Ticker ticker){
        DataBase.Tickers.add(ticker);
        System.out.println("Ticker added to memory DB: " + ticker.CreationTime.toString());

    }

    public static List<Ticker> Select(){
        return DataBase.Tickers;
    }

    public static List<Ticker> Select(String pairName){
        return DataBase.Tickers.stream().filter( ticker -> pairName.equals(ticker.PairName)).collect(Collectors.toList());
    }

    public static List<Ticker> Select(String date, String pairName){
        return DataBase.Tickers.stream().filter(
                ticker -> pairName.equals(ticker.PairName)
                && ticker.CreationTime.toString().startsWith(date)).collect(Collectors.toList());
    }
}
