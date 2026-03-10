package com.tcs.tasks;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.WebDriver;

public class ReturnToMainContent implements Task {

    public static ReturnToMainContent now() {
        return Tasks.instrumented(ReturnToMainContent.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        driver.switchTo().defaultContent();
    }
}