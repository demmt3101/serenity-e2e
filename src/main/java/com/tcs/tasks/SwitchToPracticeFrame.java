package com.tcs.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SwitchToPracticeFrame extends PageObject implements Task {

    private static final int SHORT_WAIT = 1000;
    private static final int MEDIUM_WAIT = 2000;
    private static final int LONG_WAIT = 3000;
    private static final int MAX_WAIT = 6000;

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        try {
            Thread.sleep(MEDIUM_WAIT);
            takeScreenshot();

            List<WebElement> iframes = getDriver().findElements(By.tagName("iframe"));

            if (!iframes.isEmpty()) {
                WebElement firstFrame = iframes.get(0);

                js.executeScript(
                        "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                        firstFrame
                );
                Thread.sleep(MEDIUM_WAIT);
                takeScreenshot();

                getDriver().switchTo().frame(firstFrame);
                Thread.sleep(MEDIUM_WAIT);
                takeScreenshot();

                List<WebElement> editorTexts = getDriver().findElements(By.id("tinymce"));
                if (!editorTexts.isEmpty()) {
                    actor.remember("iframeEditorText", editorTexts.get(0).getText());
                }

                getDriver().switchTo().defaultContent();
                Thread.sleep(SHORT_WAIT);
            }

            boolean interactionDone = false;

            for (WebElement frame : iframes) {
                getDriver().switchTo().defaultContent();
                Thread.sleep(SHORT_WAIT);

                js.executeScript(
                        "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                        frame
                );
                Thread.sleep(MEDIUM_WAIT);
                takeScreenshot();

                getDriver().switchTo().frame(frame);
                Thread.sleep(MEDIUM_WAIT);
                takeScreenshot();

                List<WebElement> inputs = getDriver().findElements(By.cssSelector("input"));

                for (WebElement input : inputs) {
                    if (input.isDisplayed() && input.isEnabled()) {

                        js.executeScript(
                                "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                                input
                        );
                        Thread.sleep(SHORT_WAIT);
                        takeScreenshot();

                        js.executeScript("arguments[0].click();", input);
                        Thread.sleep(SHORT_WAIT);

                        input.clear();
                        Thread.sleep(SHORT_WAIT);

                        input.sendKeys("dennis@test.com");
                        Thread.sleep(MEDIUM_WAIT);
                        takeScreenshot();

                        actor.remember("iframeEmail", input.getAttribute("value"));

                        List<WebElement> buttons = getDriver().findElements(
                                By.cssSelector("button, input[type='submit']")
                        );

                        if (!buttons.isEmpty()) {
                            WebElement button = buttons.get(0);

                            js.executeScript(
                                    "arguments[0].scrollIntoView({block:'center', inline:'center'});",
                                    button
                            );
                            Thread.sleep(SHORT_WAIT);
                            takeScreenshot();

                            js.executeScript("arguments[0].click();", button);
                            Thread.sleep(LONG_WAIT);
                            takeScreenshot();
                        }

                        List<WebElement> successMessages = getDriver().findElements(
                                By.xpath("//*[contains(text(),'You are now subscribed!')]")
                        );

                        if (!successMessages.isEmpty()) {
                            actor.remember("iframeSuccessMessage", successMessages.get(0).getText());
                            interactionDone = true;
                            takeScreenshot();
                        }

                        break;
                    }
                }

                if (interactionDone) {
                    break;
                }
            }

            getDriver().switchTo().defaultContent();
            Thread.sleep(SHORT_WAIT);

            actor.remember("iframeInteractionDone", interactionDone);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static SwitchToPracticeFrame now() {
        return instrumented(SwitchToPracticeFrame.class);
    }
}