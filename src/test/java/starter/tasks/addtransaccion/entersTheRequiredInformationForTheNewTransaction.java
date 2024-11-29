package starter.tasks.addtransaccion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.addtransaction.TransactionPage;

public class entersTheRequiredInformationForTheNewTransaction implements Task {

    private final String Fecha;
    private final String Monto;
    private final String Descripcion;

    public entersTheRequiredInformationForTheNewTransaction(String fecha, String monto, String descripcion) {
        this.Fecha = fecha;
        this.Monto = monto;
        this.Descripcion = descripcion;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(TransactionPage.BUTTON_ADD),
                Enter.theValue(this.Fecha).into(TransactionPage.SELECT_DATE),
                Enter.theValue(this.Monto).into(TransactionPage.INPUT_MOUNT),
                Enter.theValue(this.Descripcion).into(TransactionPage.INPUT_DESCRIPTION),
                Click.on(TransactionPage.BUTTON_SAVE)
        );

    }
}
