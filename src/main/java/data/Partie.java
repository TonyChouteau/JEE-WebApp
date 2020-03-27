package data;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Partie{

    private int pid;
    private int uid;
    private int gid;
    private String nameUser;
    private String nameGame;
    private Timestamp dateDebut;
    private Timestamp dateFin;

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public Partie(int pid, int uid, int gid, String nameUser, String nameGame, Timestamp dateDebut, Timestamp dateFin) {
        this.pid = pid;
        this.uid = uid;
        this.gid = gid;
        this.nameUser = nameUser;
        this.nameGame = nameGame;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Partie [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", gid=" + gid + ", nameUser=" + nameUser
                + ", pid=" + pid + ", uid=" + uid + "]";
    }

    
    

}