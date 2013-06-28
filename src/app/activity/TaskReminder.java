package app.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TaskReminder extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onClickBtLogar(View v) {
        Intent intent = new Intent(this, ListReminder.class);
        startActivityForResult(intent, 0);
    }
    public void onClickBtRegistrar(View v) {
        Intent intent = new Intent(this, Register.class);
        startActivityForResult(intent, 0);
    }
    
    
        
}
