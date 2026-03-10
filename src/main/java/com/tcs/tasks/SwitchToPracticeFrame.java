package com.tcs.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SwitchToPracticeFrame implements Task {

    private final String iframeCss;

    public SwitchToPracticeFrame(String iframeCss) {
        this.iframeCss = iframeCss;
    }

    public static SwitchToPracticeFrame using(String iframeCss) {
        return Tasks.instrumented(SwitchToPracticeFrame.class, iframeCss);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        WebElement iframe = driver.findElement(By.cssSelector(iframeCss));
        driver.switchTo().frame(iframe);
        Serenity.setSessionVariable("frameInteractionSuccess").to(true);
    }
}