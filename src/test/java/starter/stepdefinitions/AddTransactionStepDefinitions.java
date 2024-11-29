package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import starter.models.LoginModel;
import starter.models.TransactionModel;
import starter.tasks.addtransaccion.AddTransaction;
import starter.tasks.addtransaccion.CheckNewTransactionWasAdded;
import starter.tasks.login.isLoggedIntoTheApplication;
import starter.tasks.navigate.NavigateTo;
import starter.util.GetInfoFromTable;

public class AddTransactionStepDefinitions {

    @Given("{actor} is logged into the application")
    public void isLoggedIntoTheApplication(Actor actor, DataTable userLogin) {

        LoginModel loginModel = GetInfoFromTable.getLoginCredentials(userLogin);

        actor.attemptsTo(
                NavigateTo.loginPage(),
                new isLoggedIntoTheApplication(loginModel.getUsername(),
                        loginModel.getPassword())
        );
    }

    @When("{actor} enters the required information for the new transaction")
    public void entersTheRequiredInformationForTheNewTransaction(Actor actor, DataTable datos) {

        TransactionModel transactionModel = GetInfoFromTable.getTransactionData(datos);
        actor.attemptsTo(
                AddTransaction.withInfo(transactionModel.getFecha(),
                        transactionModel.getMonto(),
                        transactionModel.getDescripcion())
                /*
                new entersTheRequiredInformationForTheNewTransaction(Fecha,
                        Monto,
                        Descripcion)

                        */

        );

    }


    @Then("{actor} should see a new transaction in the transaction list with correct details")
    public void shouldSeeANewTransaction(Actor actor) {

        actor.attemptsTo(
                new CheckNewTransactionWasAdded()
        );


    }


}
