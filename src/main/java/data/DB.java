package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

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
            return test.executeUpdate("INSERT INTO User VALUES (1, 'test', 'pdptest', '1998-12-26', 0, 0)");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


}