package starter.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BeginnerStepDefinition extends PageObject {

    By txtUsername = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");
    By lblProducts = By.xpath("//span[text()='Products']");

    private static final int SHORT_WAIT = 1000;
    private static final int MEDIUM_WAIT = 2000;

    @Given("que el usuario abre la pagina de login")
    public void queElUsuarioAbreLaPaginaDeLogin() throws InterruptedException {
        openUrl("https://www.saucedemo.com/");
        Thread.sleep(MEDIUM_WAIT);
        Serenity.takeScreenshot();
    }

    @When("ingresa el usuario {string}")
    public void ingresaElUsuario(String usuario) throws InterruptedException {
        $(txtUsername).waitUntilVisible().type(usuario);
        Thread.sleep(SHORT_WAIT);
        Serenity.takeScreenshot();
    }

    @And("ingresa la contraseña {string}")
    public void ingresaLaContrasena(String password) throws InterruptedException {
        $(txtPassword).waitUntilVisible().type(password);
        Thread.sleep(SHORT_WAIT);
        Serenity.takeScreenshot();
    }

    @And("hace clic en el boton login")
    public void haceClicEnElBotonLogin() throws InterruptedException {
        $(btnLogin).waitUntilClickable().click();
        Thread.sleep(MEDIUM_WAIT);
        Serenity.takeScreenshot();
    }

    @Then("deberia visualizar la pagina principal")
    public void deberiaVisualizarLaPaginaPrincipal() throws InterruptedException {
        Thread.sleep(SHORT_WAIT);
        Serenity.takeScreenshot();

        Assert.assertTrue(
                "El login no fue exitoso",
                $(lblProducts).waitUntilVisible().isDisplayed()
        );
    }
}