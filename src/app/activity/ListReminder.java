/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import app.bd.bean.Reminder;
import app.bd.bean.User;
import app.bd.dao.ReminderDAO;
import app.bd.dao.UserDAO;
import java.util.List;

/**
 *
 * @author luis
 */
public class ListReminder extends Activity {

    /**
     * Called when the activity is first created.
     */
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listreminder);
    
        UserDAO uDAO = new UserDAO(this);
        User user = uDAO.getLogado();
        
        ReminderDAO rDAO = new ReminderDAO(this);
        List<Reminder> incompletas = rDAO.listaTodos("false");
        
        List<Reminder> completas = rDAO.listaTodos("true");
        
    }
    
    public void onClickBtAddReminder(View v) {
        Intent intent = new Intent(this, CreateReminder.class);
        startActivityForResult(intent, 0);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuprincipal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.abrirListNotes:
                Intent intent = new Intent(this, ListNote.class);
                startActivity(intent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
