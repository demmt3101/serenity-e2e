package starter.stepsDefinitions;

import com.tcs.questions.FrameInteractionResult;
import com.tcs.questions.ShadowRootInteractionResult;
import com.tcs.tasks.InteractWithShadowRoot;
import com.tcs.tasks.OpenIframePage;
import com.tcs.tasks.OpenShadowRootPage;
import com.tcs.tasks.SwitchToPracticeFrame;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class IntermediateStepDefinition {

    private Actor actor;

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    @Before
    public void setUp() {
        actor = Actor.named("Actor");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("que el usuario abre la pagina de iframe")
    public void queElUsuarioAbreLaPaginaDeIframe() {
        actor.attemptsTo(OpenIframePage.now());
    }

    @When("cambia al iframe configurado")
    public void cambiaAlIframeConfigurado() {
        actor.attemptsTo(SwitchToPracticeFrame.now());
    }

    @Then("la interaccion con iframe debe ser exitosa")
    public void laInteraccionConIframeDebeSerExitosa() {
        Assert.assertTrue(
                "No fue posible interactuar con el iframe",
                actor.asksFor(FrameInteractionResult.wasSuccessful())
        );
    }

    @Given("que el usuario abre la pagina de shadow root")
    public void queElUsuarioAbreLaPaginaDeShadowRoot() {
        actor.attemptsTo(OpenShadowRootPage.now());
    }

    @When("accede al shadow root configurado")
    public void accedeAlShadowRootConfigurado() {
        actor.attemptsTo(InteractWithShadowRoot.now());
    }

    @Then("la interaccion con shadow root debe ser exitosa")
    public void laInteraccionConShadowRootDebeSerExitosa() {
        Assert.assertTrue(
                "No fue posible interactuar con el shadow root",
                actor.asksFor(ShadowRootInteractionResult.wasSuccessful())
        );
    }
}