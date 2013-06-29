package app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
        }
    }

    public void onClickBtLogar(View v) {
        EditText nameRaw = (EditText) findViewById(R.id.txtLogin);
        EditText passwordRaw = (EditText) findViewById(R.id.txtSenha);
        
        String name = nameRaw.getText().toString();
        String password = passwordRaw.getText().toString();
        
        //Implement if get all reminder and notes in another smartphone
    
    }

    public void onClickBtRegistrar(View v) {
        Intent intent = new Intent(this, Register.class);
        startActivityForResult(intent, 0);
    }
}
