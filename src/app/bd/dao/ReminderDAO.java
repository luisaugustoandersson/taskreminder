/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;
import app.bd.BaseDados;
import app.bd.bean.Reminder;
import java.util.ArrayList;
import java.util.List;

public class ReminderDAO {

    private Context context;

    public ReminderDAO(Context context) {
        this.context = context;
    }

    public List<Reminder> listaTodos(String completo) {
        List<Reminder> listaReminder = new ArrayList<Reminder>();
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        Cursor cursor = conn.rawQuery("SELECT * FROM reminder;", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Reminder rem = new Reminder();
            rem.setCod(cursor.getInt(0));
            rem.setDescricao(cursor.getString(1));
            rem.setCompleto(cursor.getString(2));
            rem.setUser_id(cursor.getInt(3));
            rem.setSync(cursor.getString(4));
            if (rem.getCompleto().equals(completo)) {
                listaReminder.add(rem);
            }
            cursor.moveToNext();
        }
        conn.close();
        return listaReminder;
    }

    public void create(Reminder rem) {
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        ContentValues valores = new ContentValues(5);
        valores.put("cod", rem.getCod());
        valores.put("descricao", rem.getDescricao());
        valores.put("completo", rem.getCompleto());
        valores.put("user_id", rem.getUser_id());
        valores.put("sync", rem.getSync());
        if (conn.insert("reminder", null, valores) > 0) {
            System.out.println("wooow");
        }
        System.out.println("no :(");
        conn.close();
    }

    public void update(Reminder rem) {
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        ContentValues valores = new ContentValues(4);
        valores.put("cod", rem.getCod());
        valores.put("descricao", rem.getDescricao());
        valores.put("completo", rem.getCompleto());
        valores.put("user_id", rem.getUser_id());
        valores.put("sync", rem.getSync());
        conn.update("reminder", valores, "cod = " + rem.getCod(), null);
        conn.close();
    }
}
