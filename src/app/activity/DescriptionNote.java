/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import app.bd.bean.Note;
import app.bd.dao.NoteDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author luis
 */
public class DescriptionNote extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.notedescription);
       
        NoteDAO nDAO = new NoteDAO(this);
        List<Note> notes = nDAO.listaTodos();
        Iterator<Note> iterator = notes.iterator();
        List<String> data= new ArrayList<String>();
        
        while (iterator.hasNext()){
            data.add(iterator.next().getDescricao());
        }

        Intent intent = getIntent();
        Bundle params = intent.getExtras();  
        String selectedNote = params.getString("note");

        EditText txtMsgGravaTexto = (EditText) findViewById(R.id.txtDescricaoNote);
        txtMsgGravaTexto.setText(selectedNote);
        
    }
}
