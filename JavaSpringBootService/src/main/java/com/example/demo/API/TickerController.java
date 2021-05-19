package com.example.demo.API;

import com.example.demo.Models.Ticker;
import com.example.demo.Services.MemoryDataBaseService;
import com.example.demo.Services.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/ticker")
@RestController
public class TickerController{


    private static TickerService tickerService;
    @Autowired
    public TickerController(TickerService tickerService) {
        this.tickerService = tickerService;
    }

    @GetMapping
    public List<Ticker> getAllTickers(){
       //return MemoryDataBaseService.Select();
        return tickerService.GetAll();
    }
    @GetMapping(path = "{pair_name}")
    public List<Ticker> getTickersByPairName(@PathVariable("pair_name") String pairName){
        //return MemoryDataBaseService.Select(pairName);
        return tickerService.GetByPairName(pairName);
    }
    @GetMapping(path = "{date}/{pair_name}")
    public List<Ticker> getAllTickers(@PathVariable("date") String date, @PathVariable("pair_name") String pairName){
        //return MemoryDataBaseService.Select(date, pairName);
        return tickerService.GetByPairNameAndCreationTime(pairName, date);
    }
}
