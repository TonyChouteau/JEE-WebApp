package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB implements DBInt {

    private Connection connect;
    private static final DB instance = new DB();

    private DB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            connect = DriverManager.getConnection("jdbc:mysql://vps.tonychouteau.fr:3306/", "FluffyCorp", "FluffyWord");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    

    public static final DB getInstance() {
        return instance;
    }

}