package com.tcs.utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDomHelper {

    public static WebElement findElementInsideShadowRoot(String hostCss, String innerCss) {
        WebDriver driver = Serenity.getDriver();
        WebElement host = driver.findElement(By.cssSelector(hostCss));
        SearchContext shadowRoot = host.getShadowRoot();
        return shadowRoot.findElement(By.cssSelector(innerCss));
    }
}