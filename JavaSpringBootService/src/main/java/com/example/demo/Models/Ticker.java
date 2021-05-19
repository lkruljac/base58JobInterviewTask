package com.example.demo.Models;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.sql.Timestamp;

public class Ticker {
    public String CreationTime;
    public JSONObject Data;
    public String PairName;

    public Ticker(String CreationTime, String Data, String PairName) throws ParseException {
        this.CreationTime = CreationTime;
        this.Data = (JSONObject) new JSONParser().parse(Data);
        this.PairName = PairName;
    }
    public Ticker(){

    }

}
