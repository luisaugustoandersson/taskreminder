/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bd.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import app.bd.BaseDados;
import app.bd.bean.Note;
import java.util.ArrayList;
import java.util.List;

public class NoteDAO {

    private Context context;

    public NoteDAO(Context context) {
        this.context = context;
    }

    public List<Note> listaTodos() {
        List<Note> listaNotes = new ArrayList<Note>();
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        Cursor cursor = conn.rawQuery("SELECT * FROM NOTE", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Note note = new Note();
            note.setCod(cursor.getInt(0));
            note.setDescricao(cursor.getString(1));
            note.setUser_id(cursor.getInt(2));
            note.setSync(cursor.getString(3));
            listaNotes.add(note);
            cursor.moveToNext();
        }
        conn.close();
        return listaNotes;
    }

    public void create(Note note) {
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        ContentValues valores = new ContentValues(1);
        valores.put("descricao", note.getDescricao());
        valores.put("user_id", note.getUser_id());
        valores.put("sync", note.getSync());
        conn.insert("note", null, valores);
        conn.close();
    }
    
    public void update(Note note) {
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        ContentValues valores = new ContentValues(1);
        valores.put("descricao", note.getDescricao());
        valores.put("user_id", note.getUser_id());
        valores.put("sync", note.getSync());
        conn.update("note", valores, "cod = "+note.getCod(), null);
        conn.close();
    }
}
