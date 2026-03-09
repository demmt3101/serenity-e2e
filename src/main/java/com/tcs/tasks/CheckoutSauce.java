package com.tcs.tasks;

import com.tcs.UI.SauceCartUI;
import com.tcs.UI.SauceCheckoutUI;
import com.tcs.utils.SauceData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckoutSauce implements Task {

    private final SauceData.Purchase p;
    private final boolean includePostal;

    public CheckoutSauce(SauceData.Purchase p, boolean includePostal) {
        this.p = p; this.includePostal = includePostal;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SauceCartUI.CHECKOUT),
                Enter.theValue(p.firstName).into(SauceCheckoutUI.FIRST_NAME),
                Enter.theValue(p.lastName).into(SauceCheckoutUI.LAST_NAME)
        );

        if (includePostal) {
            actor.attemptsTo(Enter.theValue(p.postalCode).into(SauceCheckoutUI.POSTAL));
        }

        actor.attemptsTo(
                Click.on(SauceCheckoutUI.CONTINUE)
        );

        // En el positivo, seguimos a finish (en negativo se quedará en error)
        if (includePostal) {
            actor.attemptsTo(Click.on(SauceCheckoutUI.FINISH));
        }
    }

    public static CheckoutSauce with(SauceData.Purchase p) {
        return instrumented(CheckoutSauce.class, p, true);
    }

    public static CheckoutSauce withoutPostal(SauceData.Purchase p) {
        return instrumented(CheckoutSauce.class, p, false);
    }
}