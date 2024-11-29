package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import starter.tasks.registration.CheckNewAccountCreated;
import starter.tasks.registration.RegisterUser;
import starter.tasks.registration.deberaSalirUnMensajeDeCampoRequerido;
import starter.tasks.registration.noCompletaTodosLosCampos;
import starter.ui.registration.RegisterPage;

import java.net.URISyntaxException;
import java.util.List;


public class RegistrationStepDefinitions {


    String expectedName;
    String expectedLastName;
    String expectedAge;
    String expectedEmail;
    String expectedCountry;


    /*
    String expectedName = "julian";
    String expectedLastName = "Arias";
    String expectedAge = "33";
    String expectedEmail = "marlon1428@gmail.com";
    String expectedCountry = "Colombia";
    String mensajeAlerta = "Por favor diligencie todos los campos";
     */

    @Given("{actor} wants to sign up in the application")
    public void wantsToSignUpTheApplication(Actor actor) throws URISyntaxException {
        actor.attemptsTo(
                //Open.url("http://127.0.0.1:5500/registration/register.html")
                Open.browserOn(new RegisterPage())
        );

    }


    @When("{actor} sends the required information to sign up")
    public void sendsTheRequiredInformationToSignUp(Actor actor, DataTable userInfo) throws URISyntaxException {

        List<List<String>> rows = userInfo.asLists(String.class);

        for (List<String> columns : rows) {
            expectedName = columns.get(0);
            expectedLastName = columns.get(1);
            expectedAge = columns.get(2);
            expectedEmail = columns.get(3);
            expectedCountry = columns.get(4);


        }

        actor.attemptsTo(
                new RegisterUser(expectedName,
                        expectedLastName,
                        expectedAge,
                        expectedEmail,
                        expectedCountry)
        );

    }

    @Then("{actor} should have a new account created")
    public void shouldHaveANewAccountCreated(Actor actor) {

        actor.attemptsTo(
                new CheckNewAccountCreated(expectedName,
                        expectedLastName)


        );
    }

    @When("{actor} no completa todos los campos")
    public void noCompletaTodosLosCampos(Actor actor) {
        actor.attemptsTo(
                new noCompletaTodosLosCampos(expectedName,
                        expectedLastName)

        );

    }

    @Then("{actor} debera salir un mensaje de campo requerido")
    public void deberaSalirUnMensajeDeCampoRequerido(Actor actor) {
        actor.attemptsTo(
                new deberaSalirUnMensajeDeCampoRequerido()
        );
    }
}
