package starter.stepsDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.GivenWhenThen;

import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.is;

public class BeginnerStepDefinition {

    private Actor usuario;

    /* =======================
       WEB DRIVER (Serenity)
    ======================= */
    @Managed
    WebDriver driver;

    /* =======================
       LOCATORS
    ======================= */
    private static final Target USERNAME =
            Target.the("username field")
                    .locatedBy("#user-name");

    private static final Target PASSWORD =
            Target.the("password field")
                    .locatedBy("#password");

    private static final Target LOGIN_BUTTON =
            Target.the("login button")
                    .locatedBy("#login-button");

    private static final Target TITLE_PRODUCTS =
            Target.the("products title")
                    .locatedBy("//span[text()='Products']");

    private static final Target ADD_TO_CART_BUTTONS =
            Target.the("add to cart buttons")
                    .locatedBy("//button[contains(@id,'add-to-cart')]");

    private static final Target CART =
            Target.the("shopping cart")
                    .locatedBy("#shopping_cart_container");

    private static final Target CHECKOUT =
            Target.the("checkout button")
                    .locatedBy("#checkout");

    private static final Target FIRST_NAME =
            Target.the("first name")
                    .locatedBy("#first-name");

    private static final Target LAST_NAME =
            Target.the("last name")
                    .locatedBy("#last-name");

    private static final Target ZIP =
            Target.the("postal code")
                    .locatedBy("#postal-code");

    private static final Target CONTINUE =
            Target.the("continue button")
                    .locatedBy("#continue");

    private static final Target FINISH =
            Target.the("finish button")
                    .locatedBy("#finish");

    private static final Target ORDER_COMPLETE =
            Target.the("order completed message")
                    .locatedBy("//h2[text()='Thank you for your order!']");

    /* =======================
       HOOK
    ======================= */
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        usuario = Actor.named("Usuario");
        usuario.can(BrowseTheWeb.with(driver));
    }

    /* =======================
       STEPS
    ======================= */

    @Given("que el usuario abre la pagina de login")
    public void abreLaPaginaDeLogin() {
        usuario.attemptsTo(
                Open.url("https://www.saucedemo.com/")
        );
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void ingresaCredenciales(String user, String password) {
        usuario.attemptsTo(
                Enter.theValue(user).into(USERNAME),
                Enter.theValue(password).into(PASSWORD),
                Click.on(LOGIN_BUTTON)
        );
    }

    @Then("deberia visualizar la pagina principal")
    public void deberiaVisualizarLaPaginaPrincipal() {
        usuario.should(
                GivenWhenThen.seeThat(
                        actor -> TITLE_PRODUCTS.resolveFor(actor).isVisible(),
                        is(true)
                )
        );
    }

    @When("selecciona dos productos aleatorios y completa la compra")
    public void seleccionaDosProductosAleatoriosYCompra() {

        List<WebElementFacade> productos =
                ADD_TO_CART_BUTTONS.resolveAllFor(usuario);

        if (productos.size() < 2) {
            throw new RuntimeException("No hay suficientes productos para la compra");
        }

        // Mezclamos la lista para aleatoriedad real
        Collections.shuffle(productos);

        usuario.attemptsTo(
                // Agrega 2 productos distintos
                Click.on(productos.get(0)),
                Click.on(productos.get(1)),

                // Flujo normal de compra
                Click.on(CART),
                Click.on(CHECKOUT),

                Enter.theValue("Dennis").into(FIRST_NAME),
                Enter.theValue("Montalvo").into(LAST_NAME),
                Enter.theValue("170102").into(ZIP),

                Click.on(CONTINUE),
                Click.on(FINISH)
        );
    }

    @Then("la compra debe completarse exitosamente")
    public void laCompraDebeCompletarseExitosamente() {
        usuario.should(
                GivenWhenThen.seeThat(
                        actor -> ORDER_COMPLETE.resolveFor(actor).isVisible(),
                        is(true)
                )
        );
    }
}