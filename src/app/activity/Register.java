/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import app.bd.bean.User;
import app.bd.dao.UserDAO;
import app.sync.Syncronize;

/**
 *
 * @author luis
 */
public class Register extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public void onClickBtRegistrar(View v) {
        EditText nameRaw = (EditText) findViewById(R.id.txtUsuario);
        EditText emailRaw = (EditText) findViewById(R.id.txtEmail);
        EditText passwordRaw = (EditText) findViewById(R.id.txtSenha);
        EditText verifypasswordRaw = (EditText) findViewById(R.id.txtNovaSenha);

        String name = nameRaw.getText().toString();
        String email = emailRaw.getText().toString();
        String password = passwordRaw.getText().toString();
        String verifyPassword = verifypasswordRaw.getText().toString();

        User u = new User();
        u.setEmail(email.replaceAll("/", "-").replaceAll(" ", "2space"));
        u.setNome(name.replaceAll("/", "-").replaceAll(" ", "2space"));
        u.setSenha(password.replaceAll("/", "-").replaceAll(" ", "2space"));

        Syncronize sync = Syncronize.getSession();
        String id = sync.newUser(u);

        if (id != null) {
            u.setCod(Integer.parseInt(id));
            new UserDAO(this).create(u);
            Toast.makeText(this, "-- WELCOME --", 2000).show();
            Intent intent = new Intent(this, ListReminder.class);
            startActivity(intent);

        }
    }
}
