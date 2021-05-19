package com.example.demo.dao;


import com.example.demo.Models.Ticker;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("postgres")
public class TickerDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TickerDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public void insert(Ticker ticker){
        String sql = "" +
                "INSERT INTO ticker (" +
                " creationtime, " +
                " data, " +
                " pairname) " +
                "VALUES (?,?,?)";

        jdbcTemplate.update(
                sql,
                ticker.CreationTime,
                ticker.Data.toString(),
                ticker.PairName
        );
        System.out.println("Ticker added to postgres db");
    }


    public List<Ticker> Select(){
        String sql = "" +
                "SELECT " +
                " creationtime, " +
                " data, " +
                " pairname FROM ticker";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            String ct = resultSet.getString("creationtime");
            String d = resultSet.getString("data");
            String pn = resultSet.getString("pairname");
            Ticker t = new Ticker();
            try {
                t = new Ticker(ct, d, pn);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return  t;
        });
    }


    public  List<Ticker> Select(String pairName){
                String sql = "SELECT creationtime, data, pairname FROM ticker WHERE pairname = ?";
                List<Ticker> ts = jdbcTemplate.query(sql, new Object[]{pairName}, (resultSet, i) ->
                {
                    String ct = resultSet.getString("creationtime");
                    String d = resultSet.getString("data");
                    String pn = resultSet.getString("pairname");
                    Ticker t = new Ticker();
                    try {
                        t = new Ticker(ct, d, pn);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return  t;
                });
                return ts;
    }

    public  List<Ticker> Select(String pairName, String creationTime){
        String sql = "SELECT creationtime, data, pairname FROM ticker WHERE pairname = ? AND creationtime = ?";
        List<Ticker> ts = jdbcTemplate.query(sql, new Object[]{pairName, creationTime}, (resultSet, i) ->
        {
            String ct = resultSet.getString("creationtime");
            String d = resultSet.getString("data");
            String pn = resultSet.getString("pairname");
            Ticker t = new Ticker();
            try {
                t = new Ticker(ct, d, pn);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return  t;
        });
        return ts;
    }
}
