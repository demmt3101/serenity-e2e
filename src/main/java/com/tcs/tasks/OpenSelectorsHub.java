package com.tcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class OpenSelectorsHub implements Task {

    private final String url;

    public OpenSelectorsHub(String url) {
        this.url = url;
    }

    public static OpenSelectorsHub page(String url) {
        return Tasks.instrumented(OpenSelectorsHub.class, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(url)
        );
    }
}