package com.tcs.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class ShadowJsonReader {

    private static final String DATA_PATH = "src/test/resources/testdata/shadowData.json";

    public static ShadowData getShadowData() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(DATA_PATH));

            String url = (String) jsonObject.get("url");
            String shadowHostCss = (String) jsonObject.get("shadowHostCss");
            String shadowInnerCss = (String) jsonObject.get("shadowInnerCss");

            return new ShadowData(url, shadowHostCss, shadowInnerCss);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el archivo JSON: " + DATA_PATH, e);
        }
    }
}