package com.tcs.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SauceLoginUI {
    public static final Target USERNAME = Target.the("username")
            .located(By.id("user-name"));   // :contentReference[oaicite:4]{index=4}
    public static final Target PASSWORD = Target.the("password")
            .located(By.id("password"));    // :contentReference[oaicite:5]{index=5}
    public static final Target LOGIN = Target.the("login button")
            .located(By.id("login-button")); // :contentReference[oaicite:6]{index=6}
}