package starter.tasks.addtransaccion;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.addtransaction.TransactionPage;

public class AddTransaction {

    /*
    private final String Fecha;
    private final String Monto;
    private final String Descripcion;

    public AddTransaction(String fecha, String monto, String descripcion) {
        Fecha = fecha;
        Monto = monto;
        Descripcion = descripcion;
    }
    */

    public static Performable withInfo(String Fecha, String Monto, String Descripcion) {
        return Task.where("{0} adds a new transaction",
                Click.on(TransactionPage.BUTTON_ADD),
                Enter.theValue(Fecha).into(TransactionPage.SELECT_DATE),
                Enter.theValue(Monto).into(TransactionPage.INPUT_MOUNT),
                Enter.theValue(Descripcion).into(TransactionPage.INPUT_DESCRIPTION),
                Click.on(TransactionPage.BUTTON_SAVE)

        );

    }
}
