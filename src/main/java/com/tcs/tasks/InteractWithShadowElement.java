package com.tcs.tasks;

import com.tcs.utils.ShadowDomHelper;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InteractWithShadowElement implements Task {

    private final String hostCss;
    private final String innerCss;

    public InteractWithShadowElement(String hostCss, String innerCss) {
        this.hostCss = hostCss;
        this.innerCss = innerCss;
    }

    public static InteractWithShadowElement using(String hostCss, String innerCss) {
        return Tasks.instrumented(InteractWithShadowElement.class, hostCss, innerCss);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getDriver();
        WebElement element = ShadowDomHelper.findElementInsideShadowRoot(hostCss, innerCss);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        js.executeScript("arguments[0].click();", element);

        element.clear();
        element.sendKeys("Dennis");

        Serenity.setSessionVariable("shadowInteractionSuccess").to(true);
    }
}