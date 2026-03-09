package com.tcs.tasks;

import com.tcs.UI.SauceLoginUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginSauce implements Task {

    private final String user;
    private final String pass;

    public LoginSauce(String user, String pass) {
        this.user = user; this.pass = pass;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user).into(SauceLoginUI.USERNAME),
                Enter.theValue(pass).into(SauceLoginUI.PASSWORD),
                Click.on(SauceLoginUI.LOGIN)
        );
    }

    public static LoginSauce with(String user, String pass) {
        return instrumented(LoginSauce.class, user, pass);
    }
}