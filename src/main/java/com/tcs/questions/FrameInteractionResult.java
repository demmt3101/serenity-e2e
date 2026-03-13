package com.tcs.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class FrameInteractionResult implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean interactionDone = actor.recall("iframeInteractionDone");
        String successMessage = actor.recall("iframeSuccessMessage");

        return interactionDone != null
                && interactionDone
                && successMessage != null
                && successMessage.contains("You are now subscribed!");
    }

    public static FrameInteractionResult wasSuccessful() {
        return new FrameInteractionResult();
    }
}