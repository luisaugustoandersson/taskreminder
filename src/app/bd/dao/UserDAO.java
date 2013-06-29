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
import app.bd.bean.User;

/**
 *
 * @author vgsantoniazzi
 */
public class UserDAO {

    private Context context;

    public UserDAO(Context context) {
        this.context = context;
    }

    public User getLogado() {
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        Cursor cursor = conn.rawQuery("SELECT * FROM user;", null);
        cursor.moveToFirst();
        User user = new User();
        if (cursor.isLast()) {
            user.setCod(cursor.getInt(0));
            user.setNome(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            user.setSenha(cursor.getString(3));
            conn.close();
            return user;
        }
        conn.close();
        return null;
    }

    public void create(User user) {
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        ContentValues valores = new ContentValues(1);
        valores.put("cod", user.getCod());
        valores.put("nome", user.getNome());
        valores.put("email", user.getEmail());
        valores.put("senha", user.getSenha());
        conn.insert("user", null, valores);
        conn.close();
    }

    public void update(User user) {
        BaseDados bd = new BaseDados(this.context);
        SQLiteDatabase conn = bd.getWritableDatabase();
        ContentValues valores = new ContentValues(1);
        valores.put("nome", user.getNome());
        valores.put("email", user.getEmail());
        valores.put("senha", user.getSenha());
        conn.update("user", valores, "cod = " + user.getCod(), null);
        conn.close();
    }
}
