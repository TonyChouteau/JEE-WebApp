package data;

public class Jeu {

    private String nom;
    private int gid;
    private boolean available;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Jeu(String nom, int gid, boolean available) {
        this.nom = nom;
        this.gid = gid;
        this.available = available;
    }
}
