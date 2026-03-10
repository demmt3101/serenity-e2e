package com.tcs.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FrameInteractionResult implements Question<Boolean> {

    public static FrameInteractionResult wasSuccessful() {
        return new FrameInteractionResult();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean result = Serenity.sessionVariableCalled("frameInteractionSuccess");
        return result != null && result;
    }
}