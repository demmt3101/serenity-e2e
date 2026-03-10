package com.tcs.utils;

public class ShadowData {
    private final String url;
    private final String shadowHostCss;
    private final String shadowInnerCss;

    public ShadowData(String url, String shadowHostCss, String shadowInnerCss) {
        this.url = url;
        this.shadowHostCss = shadowHostCss;
        this.shadowInnerCss = shadowInnerCss;
    }

    public String getUrl() {
        return url;
    }

    public String getShadowHostCss() {
        return shadowHostCss;
    }

    public String getShadowInnerCss() {
        return shadowInnerCss;
    }
}