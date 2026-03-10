package com.tcs.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class IframeJsonReader {

    private static final String DATA_PATH = "src/test/resources/testdata/iframeData.json";

    public static IframeData getIframeData() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(DATA_PATH));

            String url = (String) jsonObject.get("url");
            String iframeCss = (String) jsonObject.get("iframeCss");

            return new IframeData(url, iframeCss);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el archivo JSON: " + DATA_PATH, e);
        }
    }
}