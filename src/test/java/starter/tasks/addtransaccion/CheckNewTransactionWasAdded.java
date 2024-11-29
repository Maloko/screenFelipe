package starter.tasks.addtransaccion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.questions.GetTransactionInfo;

public class CheckNewTransactionWasAdded implements Task {

    private final String Descripcion = "testing description";

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(GetTransactionInfo.getDescription()).contains(Descripcion)
        );
    }
}
