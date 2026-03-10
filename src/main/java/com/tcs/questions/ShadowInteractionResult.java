package com.tcs.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ShadowInteractionResult implements Question<Boolean> {

    public static ShadowInteractionResult wasSuccessful() {
        return new ShadowInteractionResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean result = Serenity.sessionVariableCalled("shadowInteractionSuccess");
        return result != null && result;
    }
}