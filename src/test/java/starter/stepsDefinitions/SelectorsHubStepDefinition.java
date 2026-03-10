package starter.stepsDefinitions;

import com.tcs.questions.FrameInteractionResult;
import com.tcs.questions.ShadowInteractionResult;
import com.tcs.tasks.InteractWithShadowElement;
import com.tcs.tasks.OpenSelectorsHub;
import com.tcs.tasks.SwitchToPracticeFrame;
import com.tcs.utils.IframeData;
import com.tcs.utils.IframeJsonReader;
import com.tcs.utils.ShadowData;
import com.tcs.utils.ShadowJsonReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SelectorsHubStepDefinition {

    private Actor actor;
    private IframeData iframeData;
    private ShadowData shadowData;

    @Managed(driver = "chrome")
    WebDriver hisBrowser;

    @Before
    public void setUp() {
        actor = Actor.named("Dennis");
        actor.can(BrowseTheWeb.with(hisBrowser));
        iframeData = IframeJsonReader.getIframeData();
        shadowData = ShadowJsonReader.getShadowData();
    }

    @Given("que el usuario abre la pagina de practica de SelectorsHub")
    public void abrirPaginaPractice() {
        // este Given ya no conviene usarlo para ambos escenarios
    }

    @Given("que el usuario abre la pagina de iframe")
    public void abrirPaginaIframe() {
        actor.attemptsTo(
                OpenSelectorsHub.page(iframeData.getUrl())
        );
    }

    @Given("que el usuario abre la pagina de shadow root")
    public void abrirPaginaShadow() {
        actor.attemptsTo(
                OpenSelectorsHub.page(shadowData.getUrl())
        );
    }

    @When("cambia al iframe configurado")
    public void cambiaAlIframeConfigurado() {
        actor.attemptsTo(
                SwitchToPracticeFrame.using(iframeData.getIframeCss())
        );
    }

    @When("accede al shadow root configurado")
    public void accedeAlShadowRootConfigurado() {
        actor.attemptsTo(
                InteractWithShadowElement.using(
                        shadowData.getShadowHostCss(),
                        shadowData.getShadowInnerCss()
                )
        );
    }

    @Then("la interaccion con iframe debe ser exitosa")
    public void validarIframe() {
        assertThat(actor.asksFor(FrameInteractionResult.wasSuccessful())).isTrue();
    }

    @Then("la interaccion con shadow root debe ser exitosa")
    public void validarShadow() {
        assertThat(actor.asksFor(ShadowInteractionResult.wasSuccessful())).isTrue();
    }
}