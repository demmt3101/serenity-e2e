package com.tcs.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonSauceReader {

    public static SauceData readFromClasspath(String path) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            if (is == null) throw new IllegalArgumentException("No existe en classpath: " + path);

            JSONObject root = (JSONObject) new JSONParser()
                    .parse(new InputStreamReader(is, StandardCharsets.UTF_8));

            SauceData data = new SauceData();
            data.url = str(root, "url");

            JSONObject u = (JSONObject) root.get("user");
            data.user = new SauceData.User();
            data.user.username = str(u, "username");
            data.user.password = str(u, "password");

            JSONObject p = (JSONObject) root.get("purchase");
            data.purchase = new SauceData.Purchase();
            data.purchase.firstName = str(p, "firstName");
            data.purchase.lastName = str(p, "lastName");
            data.purchase.postalCode = str(p, "postalCode");

            JSONArray arr = (JSONArray) p.get("products");
            List<String> products = new ArrayList<>();
            if (arr != null) for (Object o : arr) products.add(o.toString());
            data.purchase.products = products;

            return data;
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo JSON: " + path, e);
        }
    }

    private static String str(JSONObject obj, String key) {
        if (obj == null) return null;
        Object v = obj.get(key);
        return v == null ? null : v.toString();
    }
}