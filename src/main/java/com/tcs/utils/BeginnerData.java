package com.tcs.utils;

public class BeginnerData {
    private final String url;
    private final String expectedTitle;

    public BeginnerData(String url, String expectedTitle) {
        this.url = url;
        this.expectedTitle = expectedTitle;
    }

    public String getUrl() {
        return url;
    }

    public String getExpectedTitle() {
        return expectedTitle;
    }
}