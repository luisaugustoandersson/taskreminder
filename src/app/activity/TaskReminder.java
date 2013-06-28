package app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import app.bd.bean.User;
import app.bd.dao.UserDAO;

public class TaskReminder extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        UserDAO uDAO = new UserDAO(this);
        User user = uDAO.getLogado();
        if (user != null) {
            Intent intent = new Intent(this, ListReminder.class);
            startActivityForResult(intent, 0);
        } else {
            Intent intent = new Intent(this, Register.class);
            startActivityForResult(intent, 0);
        }
    }

    public void onClickBtLogar(View v) {
    }

    public void onClickBtRegistrar(View v) {
    }
}
