package com.tcs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ShadowRootInteractionResult implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        String buttonText = actor.recall("shadowButtonText");
        Object clicked = actor.recall("shadowClicked");

        boolean textOk = buttonText != null && !buttonText.isEmpty();
        boolean clickOk = clicked != null && Boolean.parseBoolean(clicked.toString());

        return textOk && clickOk;
    }

    public static ShadowRootInteractionResult wasSuccessful() {
        return new ShadowRootInteractionResult();
    }
}