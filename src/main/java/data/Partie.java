package data;

import java.sql.Date;

public class Partie{

    private int pid;
    private int uid;
    private int gid;
    private String nameUser;
    private Date dateDebut;
    private Date dateFin;

    public Partie(int pid, int uid, int gid, String nameUser, Date dateDebut, Date dateFin) {
        this.pid = pid;
        this.uid = uid;
        this.gid = gid;
        this.nameUser = nameUser;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Partie [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", gid=" + gid + ", nameUser=" + nameUser
                + ", pid=" + pid + ", uid=" + uid + "]";
    }

    
    

}