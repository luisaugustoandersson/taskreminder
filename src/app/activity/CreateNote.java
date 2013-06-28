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
import app.bd.dao.NoteDAO;
import app.bd.dao.ReminderDAO;

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
        NoteDAO nDAO= new NoteDAO(this);
        
        Note note = new Note();
        note.setDescricao(txtDescri.getText().toString());
        note.setSync("false");
        note.setUser_id(1);
        
        nDAO.create(note);
        
        
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
