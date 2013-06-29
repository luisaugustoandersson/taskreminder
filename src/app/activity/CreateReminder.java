/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.activity;

import android.app.Activity;
import static android.app.Activity.RESULT_OK;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import app.bd.bean.Reminder;
import app.bd.bean.User;
import app.bd.dao.ReminderDAO;
import app.bd.dao.UserDAO;
import app.sync.Syncronize;

/**
 *
 * @author luis
 */
public class CreateReminder extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.createreminder);
        Bundle bundle = this.getIntent().getExtras();
        // ToDo add your GUI initialization code here        

    }

    public void onClickBtSalvarReminder(View v) {
        EditText txtdescricao = (EditText) findViewById(R.id.txtdescricao);

        String value = txtdescricao.getText().toString();

        if (value != null && value.trim() != "") {
            Reminder rem = new Reminder();
            rem.setDescricao(txtdescricao.getText().toString());
            rem.setCompleto("false");
            rem.setUser_id(new UserDAO(this).getLogado().getCod());

            Syncronize sync = Syncronize.getSession();
            String id = sync.SyncReminder(rem, true);

            rem.setCod(Integer.parseInt(id));

            rem.setSync("true");

            new ReminderDAO(this).create(rem);

        }
        Intent intent = new Intent(this, ListReminder.class);
        startActivity(intent);
    }
}
