package com.tcs.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenSauce implements Task {

    private final String url;

    public OpenSauce(String url) { this.url = url; }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static OpenSauce at(String url) {
        return instrumented(OpenSauce.class, url);
    }
}