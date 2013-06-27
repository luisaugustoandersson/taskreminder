/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bd.bean;

/**
 *
 * @author luis
 */
public class Note {
    
    private int cod;
    private String descricao;
    private int user_id;
    private String sync;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }
    
    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Note other = (Note) obj;
        if (this.cod != other.cod) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.cod;
        return hash;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
