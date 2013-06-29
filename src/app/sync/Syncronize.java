/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.sync;

import android.widget.Toast;
import app.bd.bean.Note;
import app.bd.bean.Reminder;
import app.bd.bean.User;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author vgsantoniazzi
 */
public class Syncronize {

    private static Syncronize sync = new Syncronize();
    private String BASE_URL = "http://192.168.0.13:3000";

    public static Syncronize getSession() {
        return sync;
    }

    public String newUser(User user) {
        try {
            URL urlObj = new URL(this.BASE_URL + "/users/create/" + user.getNome() + "/" + user.getEmail() + "/" + user.getSenha() + ".json");

            HttpURLConnection httpConn = (HttpURLConnection) urlObj.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-Type", "application/json");

            if (httpConn.getResponseCode() == 200) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                InputStream in = httpConn.getInputStream();
                for (int c = in.read(); c != -1; c = in.read()) {
                    baos.write(c);
                }
                baos.close();
                return baos.toString();
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String SyncReminder(Reminder rem, boolean create) {
        try {
            URL urlObj;
            if (create) {
                urlObj = new URL(this.BASE_URL + "/sync/reminders/" + rem.getCod() + "/" + rem.getDescricao() + "/" + rem.getCompleto() + "/" + rem.getUser_id() + ".json");
            } else {
                urlObj = new URL(this.BASE_URL + "/sync/reminders/" + rem.getCod() + "/" + rem.getCod() + "/" + rem.getDescricao() + "/" + rem.getCompleto() + "/" + rem.getUser_id() + ".json");

            }
            HttpURLConnection httpConn = (HttpURLConnection) urlObj.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-Type", "application/json");

            if (httpConn.getResponseCode() == 200) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                InputStream in = httpConn.getInputStream();
                for (int c = in.read(); c != -1; c = in.read()) {
                    baos.write(c);
                }
                baos.close();
                return baos.toString();
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String SyncNotes(Note note, boolean create) {
        try {
            URL urlObj;
            if (create) {
                urlObj = new URL(this.BASE_URL + "/sync/notes/" + note.getDescricao() + "/" + note.getUser_id() + ".json");
            } else {
                urlObj = new URL(this.BASE_URL + "/sync/notes/" + note.getCod() + "/" + note.getDescricao() + "/" + note.getUser_id() + ".json");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlObj.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-Type", "application/json");

            if (httpConn.getResponseCode() == 200) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                InputStream in = httpConn.getInputStream();
                for (int c = in.read(); c != -1; c = in.read()) {
                    baos.write(c);
                }
                baos.close();
                return baos.toString();
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
