package data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

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
            while (resultset.next()){
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

}   