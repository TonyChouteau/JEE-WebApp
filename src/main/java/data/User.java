package data;

import java.sql.Date;

public class User {

    private int uid;
    private String pseudo;
    private String email;
    private Date birthday;
    private int banned;
    private int isAdmin;
    
    public User (int uid, String pseudo, String email, Date birthday, int banned, int isAdmin){
        this.uid = uid;
        this.pseudo = pseudo;
        this.email = email;
        this.birthday = birthday;
        this.banned = banned;
        this.isAdmin = isAdmin;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getBanned() {
        return banned;
    }

    public void setBanned(int banned) {
        this.banned = banned;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "User [banned=" + banned + ", birthday=" + birthday + ", email=" + email + ", isAdmin=" + isAdmin
                + ", pseudo=" + pseudo + ", uid=" + uid + "]";
    }

}