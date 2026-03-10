package com.tcs.utils;

public class IframeData {
    private final String url;
    private final String iframeCss;

    public IframeData(String url, String iframeCss) {
        this.url = url;
        this.iframeCss = iframeCss;
    }

    public String getUrl() {
        return url;
    }

    public String getIframeCss() {
        return iframeCss;
    }
}