package data;

import java.sql.*;

public class DB implements DBInt {

    private Connection connect;
    private static DB instance;




    private DB() {
        try {
            System.out.println(1);
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println(2);

            connect = DriverManager.getConnection("jdbc:mysql://vps.tonychouteau.fr:3306/jee", "FluffyCorp", "FluffyWord");
            System.out.println("lol"+connect);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DB getInstance() {
        System.out.println("test"+instance);
        if (instance==null){
            instance = new DB();
        }
        return instance;
    }

    public static void main(String[] args) throws SQLException {
        DB myInstance = DB.getInstance();
        try ( Statement test = myInstance.connect.createStatement()){
            test.executeUpdate("INSERT INTO User VALUES (1, 'test', 'pdptest', '1998-12-26', 0, 0)");
        }
        System.out.println("2");
    }

    public int truc () {
        DB myInstance = DB.getInstance();
        try ( Statement test = myInstance.connect.createStatement()){
            return test.executeUpdate("INSERT INTO User VALUES (NULL, 'test', 'pdptest', '1998-12-26', 0, 0)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int signin (String pseudo, String password) {
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM User WHERE pseudo = ? AND password = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setString(1, pseudo);
            state.setString(2, password);
            ResultSet resultset = state.executeQuery();
            if (resultset.next()){
                return resultset.getInt("idUser");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    @Override
    public int signup(String pseudo, String email, String password, Date birthday) {
        return 0;
    }

    @Override
    public int editProfile(String newUsername, String newEmail, String newPassword, Date newBirthday) {
        return 0;
    }

    @Override
    public boolean isAdmin(int uid) {
        return false;
    }

    @Override
    public void banUser(int uid) {

    }

    @Override
    public void unbanUser(int uid) {

    }

    @Override
    public void removeGame(int gid) {

    }

    @Override
    public void addGame(int gid) {

    }

    @Override
    public void submitScore(int gid, int uid, Date begin, Date end) {

    }
}