package data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public interface DBInt {

    int truc();

    Jeu getJeu (int gid);
    int signin (String pseudo, String password);
    int signup (String pseudo, String email, String password, Date birthday);
    int editProfile (int uid, String newUsername, String newEmail, String newPassword, Date newBirthday);

    boolean isAdmin (int uid);

    void banUser (int uid);
    void unbanUser (int uid);
    void removeGame (int gid);
    void addGame (int gid);

    void submitScore (int gid, int uid, Timestamp begin, Timestamp end);

    ArrayList<User> listUser ();
    ArrayList<Partie> listPartie();
    ArrayList<Partie> listPartieJeu(int gid);
    ArrayList<Partie> listPartieJoueur(int uid);
    ArrayList<Jeu> listJeux ();

    User getUser (int uid);
    String getUserPassword (int uid);

}