package com.tcs.questions;

import com.tcs.UI.SauceCheckoutUI;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class CheckoutErrorVisible {
    public static Question<Boolean> isTrue() {
        return actor -> the(SauceCheckoutUI.ERROR).answeredBy(actor).isCurrentlyVisible();
    }
}