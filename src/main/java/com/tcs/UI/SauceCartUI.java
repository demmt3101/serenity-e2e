package com.tcs.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SauceCartUI {
    public static final Target CHECKOUT = Target.the("checkout")
            .located(By.id("checkout"));
}