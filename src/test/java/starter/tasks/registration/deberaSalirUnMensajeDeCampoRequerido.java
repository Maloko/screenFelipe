package starter.tasks.registration;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.ui.registration.RegisterForm;

public class deberaSalirUnMensajeDeCampoRequerido implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(RegisterForm.LABEL_ALERT).text()
                        .containsIgnoringCase("Por favor diligencie todos los campos")
        );
    }
}
