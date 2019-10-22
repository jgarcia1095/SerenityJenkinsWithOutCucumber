package tasks;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.users.RegisterUserInfo;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import questions.ResponseCode;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegisterUserStepDefinitions {

    private final String restApiUrl = "https://reqres.in/api";
    Actor asesor;


    @Given("^Un usuario mayor de edad quiere registrarse para administrar sus servicios bancarios$")
    public void unUsuarioMayorDeEdadQuiereRegistrarseParaAdministrarSusServiciosBancarios() {
         asesor = Actor.named("Asesor")
                .whoCan(CallAnApi.at(restApiUrl));
        SerenityRest.useRelaxedHTTPSValidation();

        String registerUserInfo="{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        asesor.attemptsTo(
                RegisterUser.withInfo(registerUserInfo)
        );
        asesor.should(
                seeThat("El codigo de respuesta", ResponseCode.was(),equalTo(200))
        );

    }

    @When("^digita las credenciales de ingreso$")
    public void digitaLasCredencialesDeIngreso() {
        System.out.println("ww");

    }

    @Then("^obtiene una cuenta virtual para realizar login$")
    public void obtieneUnaCuentaVirtualParaRealizarLogin() {
        System.out.println("ww");

    }
}
