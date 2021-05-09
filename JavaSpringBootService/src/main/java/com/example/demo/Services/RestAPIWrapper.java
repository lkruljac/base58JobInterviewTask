package com.example.demo.Services;


import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


//GET Method is only one that is needed for this task, so this is only part of wrapper
public class RestAPIWrapper {

    //GET with no inputs
    public static JSONObject GET(String url) throws Exception{

            URL urlForGetRequest = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            JSONObject JSONResponse = new JSONObject();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer response = new StringBuffer();
                String readLine = null;
                while ((readLine = in.readLine()) != null) {
                    response.append(readLine);
                }
                in.close();


                JSONResponse = (JSONObject) new JSONParser().parse(response.toString());
            } else {
                System.out.println("GET DIDN'T WORKED");
            }
            return  JSONResponse;
    }

}
