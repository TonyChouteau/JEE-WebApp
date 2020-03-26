package data;

public class Jeu {

    private String name;
    private int gid;
    private boolean available;

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
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
        this.name = nom;
        this.gid = gid;
        this.available = available;
    }
}
