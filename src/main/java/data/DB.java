package data;

import java.sql.*;

public class DB implements DBInt {

    private Connection connect;
    private static DB instance;




    private DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection("jdbc:mysql://vps.tonychouteau.fr:3306/jee", "FluffyCorp", "FluffyWord");
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


    public int truc () {
        DB myInstance = DB.getInstance();
        try ( Statement test = myInstance.connect.createStatement()){
            return test.executeUpdate("INSERT INTO User VALUES (NULL, 'test', 'pdptest', '1998-12-26', 0, 0)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

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

    public int signup (String pseudo, String email, String password, Date birthday) {
        DB myInstance = DB.getInstance();
        String sql = "INSERT INTO User VALUES (null, ?, ?, ?, ?, 0, 0);";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setString(1, pseudo);
            state.setString(2, email);
            state.setString(3, password);
            state.setDate(4, birthday);
            int result = state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int editProfile(int uid, String newUsername, String newEmail, String newPassword, Date newBirthday) {
        return 0;
    }

    @Override
    public boolean isAdmin(int uid) {
        return false;
    }

    public void banUser (int uid){
        DB myInstance = DB.getInstance();
        String sql = "UPDATE TABLE User SET banned = 1 where idUser = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, uid);
            int result = state.executeUpdate();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void unbanUser (int uid){
        DB myInstance = DB.getInstance();
        String sql = "UPDATE TABLE User SET banned = 0 where idUser = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, uid);
            int result = state.executeUpdate();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeGame (int gid){
        DB myInstance = DB.getInstance();
        String sql = "UPDATE TABLE Game SET available = 0 where idGame = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, gid);
            int result = state.executeUpdate();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addGame (int gid){
        DB myInstance = DB.getInstance();
        String sql = "UPDATE TABLE Game SET available = 1 where idGame = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, gid);
            int result = state.executeUpdate();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitScore (int gid, int uid, Date begin, Date end){
        DB myInstance = DB.getInstance();
        String sql = "INSERT INTO GamesFinished VALUES (null, ?, ?, ?, ?, ?);";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, gid);
            state.setLong(2, uid);
            state.setDate(3, begin);
            state.setDate(4, end);
            int result = state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int editProfile(int uid, String newUsername, String newEmail, String newPassword, Date newBirthday) {
        DB myInstance = DB.getInstance();
        String sql = "UPDATE TABLE User SET pseudo = ?, email = ?, password = ?, birthday = ? WHERE idUser = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setString(1, newUsername);
            state.setString(2, newEmail);
            state.setString(3, newPassword);
            state.setDate(4, newBirthday);
            state.setLong(5, uid);
            int result = state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public boolean isAdmin(int uid) {
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM User WHERE idUser = ? ;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, uid);
            ResultSet resultset = state.executeQuery();
            if (resultset.next()){
                return ( resultset.getInt("isAdmin")==1 );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}