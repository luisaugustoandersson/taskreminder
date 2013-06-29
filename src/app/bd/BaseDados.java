package app.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 *
 * @author mertins
 */
public class BaseDados extends SQLiteOpenHelper {

    public BaseDados(Context context) {
        super(context, "BDTASKREMINDER2", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        
     
        db.execSQL(
        "CREATE TABLE user (cod INTEGER NOT NULL, nome TEXT NOT NULL, email TEXT NOT NULL, senha TEXT NOT NULL);"
        );
        
        db.execSQL(
        "CREATE TABLE reminder (cod INTEGER NOT NULL, descricao TEXT NOT NULL, completo TEXT NOT NULL, user_id INTEGER, sync TEXT NOT NULL, FOREIGN KEY (user_id) REFERENCES user (id));"
        );
        
        db.execSQL(
                "CREATE TABLE note (cod INTEGER NOT NULL, descricao TEXT NOT NULL, "
                +"user_id INTEGER, sync TEXT NOT NULL);"
        );
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
        db.execSQL("DROP TABLE IF EXISTS user;");
        db.execSQL("DROP TABLE IF EXISTS note;");
        db.execSQL("DROP TABLE IF EXISTS reminder;");
        this.onCreate(db);
    }
}