package data;

import java.util.Date;

public interface DBInt {

    int truc();

    int signin (String pseudo, String password);
    int signup (String pseudo, String email, String password, Date birthday);

    void banUser (int uid);
    void unbanUser (int uid);
    void removeGame (int gid);
    void addGame (int gid);

    void submitScore (int gid, int uid, Date begin, Date end);

    void editProfile (int gid, String pseudo, String password, Date birthday);


}