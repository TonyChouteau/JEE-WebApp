package data;

import java.sql.Date;

public interface DBInt {

    int truc();

    int signin (String pseudo, String password);
    int signup (String pseudo, String email, String password, Date birthday);
    int editProfile (String newUsername, String newEmail, String newPassword, Date newBirthday);

    boolean isAdmin (int uid);

    void banUser (int uid);
    void unbanUser (int uid);
    void removeGame (int gid);
    void addGame (int gid);

    void submitScore (int gid, int uid, Date begin, Date end);


}