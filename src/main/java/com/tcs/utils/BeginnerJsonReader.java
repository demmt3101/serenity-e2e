package com.tcs.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class BeginnerJsonReader {

    private static final String DATA_PATH = "src/test/resources/testdata/beginnerData.json";

    public static BeginnerData getBeginnerData() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(DATA_PATH));

            String url = (String) jsonObject.get("url");
            String expectedTitle = (String) jsonObject.get("expectedTitle");

            return new BeginnerData(url, expectedTitle);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el archivo JSON: " + DATA_PATH, e);
        }
    }
}