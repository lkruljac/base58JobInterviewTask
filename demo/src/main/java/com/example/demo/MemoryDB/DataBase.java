package com.example.demo.MemoryDB;

import com.example.demo.Models.Ticker;

import java.util.*;

public class DataBase {

    public static List<Ticker> DB = new ArrayList<>() ;

    public static int insertTicker(Ticker ticker){
        DB.add(ticker);
        return  0;
    }
}

