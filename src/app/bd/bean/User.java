/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bd.bean;

/**
 *
 * @author luis
 */
public class User {
    private int cod;
    private String nome;
    private String senha;
    private String email;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
