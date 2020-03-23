package data;

import java.util.Date;

public interface DBInt {

    int truc();

    boolean signin (String pseudo, String password);
    boolean signup (String pseudo, String password, Date birthday);

    void banUser (int uid);
    void unbanUser (int uid);
    void removeGame (int gid);
    void addGame (int gid);

    void editProfile (int gid, String pseudo, String password, Date birthday);


}