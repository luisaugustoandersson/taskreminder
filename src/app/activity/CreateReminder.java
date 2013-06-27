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
        ReminderDAO remDAO = new ReminderDAO(this);
        Reminder rem = new Reminder();
        
        UserDAO uDAO = new UserDAO(this);
        User user = uDAO.getLogado();
        
        EditText txtdescricao = (EditText) findViewById(R.id.txtdescricao);
        rem.setDescricao(txtdescricao.getText().toString());
        rem.setCompleto("false");
        rem.setUser_id(user.getCod());
        rem.setSync("false");
        remDAO.create(rem);
        
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
