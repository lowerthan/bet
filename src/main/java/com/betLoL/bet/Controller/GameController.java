package com.betLoL.bet.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

@RestController
@RequestMapping("/Game")
public class GameController {

    @Value("${riot-api-key}")
    private String riotApiKey;


    @PostMapping("/NameToUserData")
    public String NameToUserData(@RequestParam String name) throws IOException {
        String NameToUserDataURL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name + "?api_key=" + riotApiKey;
        URL url = new URL(NameToUserDataURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            return "Failed : HTTP error code : " + conn.getResponseCode();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        String output;
        String result = "";
        while ((output = br.readLine()) != null) {
            result += output;
        }
        conn.disconnect();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(result, Map.class);

        return result;
    }

    @PostMapping("/Testtlqkf")
    public String Testtlqkf() {
        return "Testtlqkf";
    }



}


