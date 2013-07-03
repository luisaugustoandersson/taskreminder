/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import app.bd.bean.Reminder;
import app.bd.bean.User;
import app.bd.dao.ReminderDAO;
import app.bd.dao.UserDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author luis
 */
public class ListReminder extends Activity {

    private int lastPosition;
    private View selectedView;
    ListView listareminders;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listreminder);

        UserDAO uDAO = new UserDAO(this);
        User user = uDAO.getLogado();

        ReminderDAO rDAO = new ReminderDAO(this);
        List<Reminder> incompletas = rDAO.listaTodos("false");

        List<Reminder> completas = rDAO.listaTodos("true");

        TextView txtcompletos = (TextView) findViewById(R.id.txtnumerocompletos);
        txtcompletos.setText(String.valueOf(completas.size()));

        listareminders = (ListView) findViewById(R.id.listtarefas);


        Iterator<Reminder> iterator = incompletas.iterator();

        List<String> data = new ArrayList<String>();

        while (iterator.hasNext()) {
            data.add(iterator.next().getDescricao());
        }

        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listareminders.setAdapter(list);

        listareminders.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(
                        ListReminder.this);
                adb.setTitle("Finalizar esta Tarefa?");
                adb.setMessage(""+listareminders.getItemAtPosition(position));
                adb.setPositiveButton("Sim", null);
                adb.setNegativeButton("Não", null);
                adb.show();
            }
        });


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
