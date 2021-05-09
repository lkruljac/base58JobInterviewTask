package com.example.demo.Services;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BackgroundScheduledJob {

    private static int periodInMinutes = 3;

    public static void Start(){
        ScheduledExecutorService executorService;
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(
                BackgroundScheduledJob::MainCallback,
                0,
                periodInMinutes,
                TimeUnit.SECONDS);
    }

    public static void MainCallback(){
        if(Kraken.GetTickerInformation() != 1){
            System.err.println("Error occurred during fetching data from Kraken.");
        };
    }
}
