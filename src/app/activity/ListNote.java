/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import app.bd.bean.Note;
import app.bd.bean.Reminder;
import app.bd.bean.User;
import app.bd.dao.NoteDAO;
import app.bd.dao.ReminderDAO;
import app.bd.dao.UserDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author luis
 */
public class ListNote extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listnote);
        
        UserDAO uDAO = new UserDAO(this);
        User user = uDAO.getLogado();
        
        NoteDAO nDAO = new NoteDAO(this);
        
        List<Note> notes = nDAO.listaTodos();
       
        ListView listanotes = (ListView) findViewById(R.id.listnotes);
        
        
        Iterator<Note> iterator = notes.iterator();
        
        List<String> data= new ArrayList<String>();
        
        while (iterator.hasNext()){
            data.add(iterator.next().getDescricao());
        }
        
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listanotes.setAdapter(list);
        
    }
    public void onClickBtAddNote(View v) {
        Intent intent = new Intent(this, CreateNote.class);
        startActivityForResult(intent, 0);
    }
}
