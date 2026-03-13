package com.tcs.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.core.Serenity.takeScreenshot;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InteractWithShadowRoot extends PageObject implements Task {

    private static final int SHORT_WAIT = 1000;
    private static final int MEDIUM_WAIT = 2000;
    private static final int LONG_WAIT = 3000;
    private static final int MAX_WAIT = 6000;

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        try {
            Thread.sleep(LONG_WAIT);
            takeScreenshot();

            js.executeScript(
                    """
                    const all = document.querySelectorAll('*');
                    for (const el of all) {
                        if (el.shadowRoot) {
                            el.scrollIntoView({block:'center', inline:'center'});
                            return el;
                        }
                    }
                    return null;
                    """
            );

            Thread.sleep(MEDIUM_WAIT);
            takeScreenshot();

            String buttonText = (String) js.executeScript(
                    """
                    const all = document.querySelectorAll('*');
                    for (const el of all) {
                        if (el.shadowRoot) {
                            const btn = el.shadowRoot.querySelector('button');
                            if (btn) {
                                btn.scrollIntoView({block:'center', inline:'center'});
                                return btn.textContent.trim();
                            }
                        }
                    }
                    return null;
                    """
            );

            Thread.sleep(SHORT_WAIT);
            takeScreenshot();

            Object clicked = js.executeScript(
                    """
                    const all = document.querySelectorAll('*');
                    for (const el of all) {
                        if (el.shadowRoot) {
                            const btn = el.shadowRoot.querySelector('button');
                            if (btn) {
                                btn.scrollIntoView({block:'center', inline:'center'});
                                btn.click();
                                return true;
                            }
                        }
                    }
                    return false;
                    """
            );

            actor.remember("shadowButtonText", buttonText);
            actor.remember("shadowClicked", clicked);

            Thread.sleep(LONG_WAIT);
            takeScreenshot();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static InteractWithShadowRoot now() {
        return instrumented(InteractWithShadowRoot.class);
    }
}