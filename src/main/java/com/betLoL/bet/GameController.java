package com.betLoL.bet;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("/Game")
public class GameController {

    @PostMapping("/ChampionRotation")
    public String NowPlaying() throws IOException {
        String testurl = "https://kr.api.riotgames.com/lol/platform/v3/champion-rotations";
        URL url = new URL(testurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-Riot-Token", "RGAPI-73b012dc-0400-4064-bf35-d3096e179dbf");

        int responseCode = conn.getResponseCode(); // 응답결과
        String result = "";

        if(responseCode == HttpURLConnection.HTTP_OK) { // 응답에 성공 하면
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            br.close();
        }
        return result;
    }
}
