/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import app.bd.bean.Note;
import app.bd.dao.NoteDAO;
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
        List<Note> notes = new NoteDAO(this).listaTodos();
    }
    public void onClickBtAddNote(View v) {
        Intent intent = new Intent(this, CreateNote.class);
        startActivityForResult(intent, 0);
    }
}
