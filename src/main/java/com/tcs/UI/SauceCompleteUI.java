package com.tcs.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SauceCompleteUI {
    public static final Target COMPLETE_HEADER = Target.the("complete header")
            .located(By.cssSelector("h2.complete-header"));
}