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
        // ToDo add your GUI initialization code here        
        
    }
    public void onClickBtSalvarNote(View v) {
//        EditText txtTitulo = (EditText) findViewById(R.id.txttitulo);
        EditText txtDescri = (EditText) findViewById(R.id.txtdescricao);
        ReminderDAO notesDAO = new ReminderDAO(this);
//        Departamento dept = new Departamento();
//        dept.setDescricao(txtMsg1Tela1.getText().toString());
//        deptDAO.create(dept);
        
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
//        bundle.putString("vlrRetorno", txtTitulo.getText().toString());
        bundle.putString("vlrRetorno", txtDescri.getText().toString());
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }
}
