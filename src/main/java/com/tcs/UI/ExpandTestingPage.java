package com.tcs.UI;

import net.serenitybdd.screenplay.targets.Target;

public class ExpandTestingPage {

    public static final String IFRAME_URL = "https://practice.expandtesting.com/iframe";
    public static final String SHADOW_ROOT_URL = "https://practice.expandtesting.com/shadowdom";

    public static final Target EMAIL_IFRAME = Target.the("iframe interno de suscripcion")
            .locatedBy("(//iframe)[2]");

    public static final Target EMAIL_INPUT = Target.the("campo email")
            .locatedBy("//input[@type='email']");

    public static final Target SUBSCRIBE_BUTTON = Target.the("boton subscribe")
            .locatedBy("//button[contains(.,'Subscribe')] | //input[@type='submit']");
}