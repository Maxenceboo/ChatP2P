package chatSystem.model;

public class Personne {
    private String pseudo;
    private String ip;

    public Personne(String pseudo, String ip) {
        this.pseudo = pseudo;
        this.ip = ip;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public String getIp() {
        return this.ip;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String toString() {
        return this.pseudo;
    }

}