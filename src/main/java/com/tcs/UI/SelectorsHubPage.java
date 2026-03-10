package com.tcs.UI;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectorsHubPage {

    public static final Target PRACTICE_IFRAME = Target.the("practice iframe")
            .located(By.cssSelector("iframe"));

    public static final Target PAGE_BODY = Target.the("page body")
            .located(By.tagName("body"));
}