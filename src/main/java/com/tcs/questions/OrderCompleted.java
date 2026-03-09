package com.tcs.questions;

import com.tcs.UI.SauceCompleteUI;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class OrderCompleted {
    public static Question<Boolean> isTrue() {
        return actor -> the(SauceCompleteUI.COMPLETE_HEADER).answeredBy(actor).isCurrentlyVisible();
    }
}
