package com.example.demo.Services;

import com.example.demo.Models.Ticker;
import com.example.demo.dao.TickerDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TickerService {
    private final TickerDataAccessService tickerDataAccessService;

    @Autowired
    public TickerService(TickerDataAccessService tickerDataAccessService){
        this.tickerDataAccessService = tickerDataAccessService;
    }

    public void Insert(Ticker ticker){
        tickerDataAccessService.insert(ticker);
    }

    public List<Ticker> GetAll(){
        return tickerDataAccessService.Select();
    }

    public List<Ticker> GetByPairName(String PairName){
        return tickerDataAccessService.Select(PairName);
    }

    public List<Ticker> GetByPairNameAndCreationTime(String PairName, String CreationTime){
        return tickerDataAccessService.Select(PairName, CreationTime);
    }
}
