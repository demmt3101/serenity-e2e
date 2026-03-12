package starter.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;

public class BeginnerStepDefinition extends PageObject {

    By txtUsername = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");
    By lblProducts = By.xpath("//span[text()='Products']");

    @Given("que el usuario abre la pagina de login")
    public void queElUsuarioAbreLaPaginaDeLogin() throws InterruptedException {
        openUrl("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }

    @When("ingresa el usuario {string}")
    public void ingresaElUsuario(String usuario) throws InterruptedException {
        $(txtUsername).waitUntilVisible().type(usuario);
        Thread.sleep(1000);
    }

    @And("ingresa la contraseña {string}")
    public void ingresaLaContrasena(String password) throws InterruptedException {
        $(txtPassword).waitUntilVisible().type(password);
        Thread.sleep(1000);
    }

    @And("hace clic en el boton login")
    public void haceClicEnElBotonLogin() throws InterruptedException {
        $(btnLogin).waitUntilClickable().click();
        Thread.sleep(2000);
    }

    @Then("deberia visualizar la pagina principal")
    public void deberiaVisualizarLaPaginaPrincipal() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(
                "El login no fue exitoso",
                $(lblProducts).waitUntilVisible().isDisplayed()
        );
    }
}