package edu.utnfrc.iaew.tp2.model;

/**
 * @author Angelo Wolf, Patricio Carranza
 * @version 1.00.001
 * Ultimo cambio: 17/05/2016
 */
public class Usuario {

    private int id;
    private String nick, clave;

    public Usuario() {
    }

    public Usuario(String nick, String clave) {
        this.nick = nick;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nick=" + nick + ", clave=?????}";
    }

}
