package starter.ui.login;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static Target INPUT_NAME = Target.the("input user").locatedBy("//input[@id='username']");
    public static Target INPUT_PASSWORD = Target.the("input password").locatedBy("//input[@id='password']");
    public static Target BUTTON_LOGIN = Target.the("boton login").locatedBy("//button[contains(text(),'Iniciar sesión')]");

}
