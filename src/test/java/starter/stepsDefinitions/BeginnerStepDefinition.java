package starter.stepsDefinitions;

import com.tcs.UI.LoginPage;
import com.tcs.utils.BeginnerData;
import com.tcs.utils.BeginnerJsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class BeginnerStepDefinition {

    @Managed(driver = "chrome")
    WebDriver driver;

    private final LoginPage loginPage = new LoginPage();
    private final BeginnerData data = BeginnerJsonReader.getBeginnerData();

    @Given("que el usuario abre la página de SauceDemo")
    public void queElUsuarioAbreLaPaginaDeSauceDemo() {
        loginPage.setDriver(driver);
        loginPage.openPage(data.getUrl());
    }

    @Then("el título de la página debe ser {string}")
    public void elTituloDeLaPaginaDebeSer(String tituloEsperado) {
        assertThat(loginPage.getCurrentTitle()).isEqualTo(tituloEsperado);
    }

    @Then("el logo de la aplicación debe ser visible")
    public void elLogoDebeSerVisible() {
        assertThat(loginPage.isLogoVisible()).isTrue();
    }

    @Then("el campo username debe ser visible")
    public void elCampoUsernameDebeSerVisible() {
        assertThat(loginPage.isUsernameVisible()).isTrue();
    }

    @Then("el campo password debe ser visible")
    public void elCampoPasswordDebeSerVisible() {
        assertThat(loginPage.isPasswordVisible()).isTrue();
    }

    @Then("el botón login debe ser visible")
    public void elBotonLoginDebeSerVisible() {
        assertThat(loginPage.isLoginButtonVisible()).isTrue();
    }
}