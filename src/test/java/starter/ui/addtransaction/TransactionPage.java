package starter.ui.addtransaction;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class TransactionPage {

    public static Target SELECT_DATE = Target.the("select date").locatedBy("//input[@type='date']");
    public static Target INPUT_MOUNT = Target.the("input mount").located(By.id("amount"));
    public static Target INPUT_DESCRIPTION = Target.the("input description").located(By.id("description"));
    public static Target BUTTON_SAVE = Target.the("boton save").locatedBy("//button[contains(.,'Guardar')]");
    public static Target BUTTON_ADD = Target.the("boton add").locatedBy("//button[contains(.,'Añadir transacción')]");
    public static Target TRANSACTION_LIST = Target.the("boton add").locatedBy("//tbody[@id='transactions-list']");

    public static String TRANSACTION_LIST2 = "//tbody[@id='transactions-list']";

}
