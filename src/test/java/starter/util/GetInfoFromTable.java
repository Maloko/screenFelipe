package starter.util;

import io.cucumber.datatable.DataTable;
import starter.models.LoginModel;
import starter.models.TransactionModel;

import java.util.List;

public class GetInfoFromTable {

    public static LoginModel getLoginCredentials(DataTable userLogin) {
        List<List<String>> rows = userLogin.asLists(String.class);
        String username = "";
        String password = "";


        for (List<String> columns : rows) {
            username = columns.get(0);
            password = columns.get(1);
        }

        LoginModel loginModel = new LoginModel();
        loginModel.setUsername(username);
        loginModel.setPassword(password);

        return loginModel;
    }

    public static TransactionModel getTransactionData(DataTable data) {
        List<List<String>> rows = data.asLists(String.class);
        String fecha = "";
        String monto = "";
        String descripcion = "";

        for (List<String> columns : rows) {
            fecha = columns.get(0);
            monto = columns.get(1);
            descripcion = columns.get(2);
        }

        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setFecha(fecha);
        transactionModel.setMonto(monto);
        transactionModel.setDescripcion(descripcion);

        return transactionModel;
    }

}
