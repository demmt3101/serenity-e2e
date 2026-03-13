package com.tcs.tasks;

import com.tcs.UI.ExpandTestingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenShadowRootPage implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(ExpandTestingPage.SHADOW_ROOT_URL));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static OpenShadowRootPage now() {
        return instrumented(OpenShadowRootPage.class);
    }
}