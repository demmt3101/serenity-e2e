package com.tcs.UI;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private final By logo = By.className("login_logo");
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    public void openPage(String url) {
        openUrl(url);
    }

    public String getCurrentTitle() {
        return getDriver().getTitle();
    }

    public boolean isLogoVisible() {
        WebElementFacade element = find(logo);
        return element.isVisible();
    }

    public boolean isUsernameVisible() {
        WebElementFacade element = find(usernameInput);
        return element.isVisible();
    }

    public boolean isPasswordVisible() {
        WebElementFacade element = find(passwordInput);
        return element.isVisible();
    }

    public boolean isLoginButtonVisible() {
        WebElementFacade element = find(loginButton);
        return element.isVisible();
    }
}