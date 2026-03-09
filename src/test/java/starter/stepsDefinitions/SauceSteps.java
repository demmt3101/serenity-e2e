package starter.stepsDefinitions;

import com.tcs.questions.CheckoutErrorVisible;
import com.tcs.questions.OrderCompleted;
import com.tcs.tasks.*;
import com.tcs.utils.JsonSauceReader;
import com.tcs.utils.SauceData;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.Assert;

public class SauceSteps {

    private Actor actor;
    private SauceData data;

    @Before
    public void setup() {
        actor = Actor.named("Usuario");
        actor.can(BrowseTheWeb.with(ThucydidesWebDriverSupport.getDriver()));
    }

    @Given("cargo los datos de SauceDemo desde {string}")
    public void cargo_datos(String path) {
        data = JsonSauceReader.readFromClasspath(path);
        Assert.assertNotNull(data.url);
        Assert.assertNotNull(data.user);
        Assert.assertNotNull(data.purchase);
    }

    @Given("ingreso a SauceDemo y hago login con datos del JSON")
    public void login() {
        actor.attemptsTo(
                OpenSauce.at(data.url),
                LoginSauce.with(data.user.username, data.user.password)
        );
    }

    @When("agrego los productos del JSON al carrito")
    public void agrego_productos() {
        actor.attemptsTo(AddProductsToCart.from(data.purchase.products));
    }

    @When("hago checkout con datos del JSON")
    public void checkout_ok() {
        actor.attemptsTo(CheckoutSauce.with(data.purchase));
    }

    @When("intento hacer checkout sin postal code")
    public void checkout_bad() {
        actor.attemptsTo(CheckoutSauce.withoutPostal(data.purchase));
    }

    @Then("debo ver la pantalla de orden completada")
    public void valido_ok() {
        actor.attemptsTo(Ensure.that(OrderCompleted.isTrue()).isTrue());
    }

    @Then("debo ver un mensaje de error en el checkout")
    public void valido_error() {
        actor.attemptsTo(Ensure.that(CheckoutErrorVisible.isTrue()).isTrue());
    }
}