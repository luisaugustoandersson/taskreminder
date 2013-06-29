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
import app.bd.bean.Note;
import app.bd.bean.User;
import app.bd.dao.NoteDAO;
import app.bd.dao.ReminderDAO;
import app.bd.dao.UserDAO;
import app.sync.Syncronize;

/**
 *
 * @author luis
 */
public class CreateNote extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.createnote);
        Bundle bundle = this.getIntent().getExtras();
        
    }
    public void onClickBtSalvarNote(View v) {
        EditText txtDescri = (EditText) findViewById(R.id.txtdescricao);
       
        Note note = new Note();
        note.setDescricao(txtDescri.getText().toString());
        note.setSync("false");
        note.setUser_id(new UserDAO(this).getLogado().getCod());
        
        Syncronize sync = Syncronize.getSession();
        String id = sync.SyncNotes(note, true);
        
        note.setCod(Integer.parseInt(id));
 
        new NoteDAO(this).create(note);
        
        Intent intent = new Intent(this, ListNote.class);
        startActivity(intent);
    }
}
