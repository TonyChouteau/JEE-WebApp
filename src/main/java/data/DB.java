package data;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.*;
import java.util.ArrayList;

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
        if (instance==null){
            instance = new DB();
        }
        System.out.println(instance);
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

    public Jeu getJeu (int gid) {
        DB inst = DB.getInstance();
        String sql = "SELECT * FROM Game WHERE idGame = ?;";
        try ( PreparedStatement state = inst.connect.prepareStatement(sql)) {
            state.setInt(1, gid);

            ResultSet resultset = state.executeQuery();
            if (resultset.next()){
                int id = resultset.getInt("idGame");
                String name = resultset.getString("name");
                boolean available = (resultset.getInt("available") == 1);
                return new Jeu(name, id, available);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int signin (String pseudo, String password) {
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM User WHERE pseudo = ? AND password = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String s = new String(encodedhash, StandardCharsets.UTF_8);
            state.setString(1, pseudo);
            state.setString(2, s);
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
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String s = new String(encodedhash, StandardCharsets.UTF_8);
            state.setString(1, pseudo);
            state.setString(2, email);
            state.setString(3, s);
            state.setDate(4, birthday);
            int result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sql2 = "SELECT * FROM User WHERE pseudo = ?;";
        try ( PreparedStatement state2 = myInstance.connect.prepareStatement(sql2)){
            state2.setString(1, pseudo);
            ResultSet resultset = state2.executeQuery();
            if (resultset.next()){
                return ( resultset.getInt("idUser"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }



    public void banUser (int uid){
        DB myInstance = DB.getInstance();
        String sql = "UPDATE User SET banned = 1 where idUser = ?;";
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
        String sql = "UPDATE User SET banned = 0 where idUser = ?;";
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
        String sql = "UPDATE Game SET available = 0 where idGame = ?;";
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
        String sql = "UPDATE Game SET available = 1 where idGame = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, gid);
            int result = state.executeUpdate();
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submitScore (int gid, int uid, Timestamp begin, Timestamp end){
        DB myInstance = DB.getInstance();
        String sql = "INSERT INTO GamesFinished VALUES (null, ?, ?, ?, ?);";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, gid);
            state.setLong(2, uid);
            state.setTimestamp(3, begin);
            state.setTimestamp(4, end);
            int result = state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int editProfilePseudo(int uid, String newUsername) {
        DB myInstance = DB.getInstance();
        String sql = "UPDATE User SET pseudo = ? WHERE idUser = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setString(1, newUsername);
            state.setLong(2, uid);
            int result = state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public int editProfilePassword(int uid, String newPassword) {
        DB myInstance = DB.getInstance();
        String sql = "UPDATE User SET password = ? WHERE idUser = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(newPassword.getBytes(StandardCharsets.UTF_8));
            String s = new String(encodedhash, StandardCharsets.UTF_8);
            state.setString(1, s);
            state.setLong(2, uid);
            int result = state.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    public int editProfileEmail(int uid, String newEmail) {
        DB myInstance = DB.getInstance();
        String sql = "UPDATE User SET email = ? WHERE idUser = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setString(1, newEmail);
            state.setLong(2, uid);
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

    public ArrayList<User> listUser(){
        ArrayList<User> list = new ArrayList<>();
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM User;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            ResultSet resultset = state.executeQuery();
            while (resultset.next()){
                int uid = resultset.getInt("idUser");
                String pseudo = resultset.getString("pseudo");
                String email = resultset.getString("email");
                Date birthday = resultset.getDate("birthday");
                int banned = resultset.getInt("banned");
                int isAdmin = resultset.getInt("isAdmin");
                User usr = new User(uid, pseudo, email, birthday, banned, isAdmin);
                list.add(usr);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Partie> listPartie(){
        ArrayList<Partie> list = new ArrayList<>();
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM GamesFinished JOIN User ON GamesFinished.user = User.idUser JOIN Game ON Game.idGame = GamesFinished.game;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            ResultSet resultset = state.executeQuery();
            while (resultset.next()){
                int pid = resultset.getInt("idPartie");
                int uid = resultset.getInt("user");
                int gid = resultset.getInt("game");
                String pseudo = resultset.getString("pseudo");
                String nomJeu = resultset.getString("name");
                Timestamp debut = resultset.getTimestamp("gameBeginD");
                Timestamp fin = resultset.getTimestamp("gameEndD");
                Partie game = new Partie(pid, uid, gid, pseudo, nomJeu, debut, fin);
                list.add(game);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Partie> listPartieJeu(int gid){
        ArrayList<Partie> list = new ArrayList<>();
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM GamesFinished JOIN User ON GamesFinished.user = User.idUser JOIN Game ON Game.idGame = GamesFinished.game WHERE game = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setInt(1, gid);
            ResultSet resultset = state.executeQuery();
            while (resultset.next()){
                int pid = resultset.getInt("idPartie");
                int uid = resultset.getInt("user");
                int gameid = resultset.getInt("game");
                String pseudo = resultset.getString("pseudo");
                String nomJeu = resultset.getString("name");
                Timestamp debut = resultset.getTimestamp("gameBeginD");
                Timestamp fin = resultset.getTimestamp("gameEndD");
                Partie game = new Partie(pid, uid, gameid, pseudo, nomJeu, debut, fin);
                list.add(game);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Partie> listPartieJoueur(int uid){
        ArrayList<Partie> list = new ArrayList<>();
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM GamesFinished JOIN User ON GamesFinished.user = User.idUser JOIN Game ON Game.idGame = GamesFinished.game WHERE user = ? ORDER BY gameEndD LIMIT 3;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setInt(1, uid);
            ResultSet resultset = state.executeQuery();
            while (resultset.next()){
                int pid = resultset.getInt("idPartie");
                int userid = resultset.getInt("user");
                int gameid = resultset.getInt("game");
                String pseudo = resultset.getString("pseudo");
                String nomJeu = resultset.getString("name");
                Timestamp debut = resultset.getTimestamp("gameBeginD");
                Timestamp fin = resultset.getTimestamp("gameEndD");
                Partie game = new Partie(pid, userid, gameid, pseudo, nomJeu, debut, fin);
                list.add(game);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<Jeu> listJeux() {

        ArrayList<Jeu> list = new ArrayList<>();
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM Game;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            ResultSet resultset = state.executeQuery();
            while (resultset.next()){
                String name = resultset.getString("name");
                int gid = resultset.getInt("idGame");
                boolean av = (resultset.getInt("available") == 1);
                list.add(new Jeu(name, gid, av));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public User getUser(int uid){
        DB myInstance = DB.getInstance();
        String sql = "SELECT * FROM User WHERE idUser = ?;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setInt(1, uid);
            ResultSet resultset = state.executeQuery();
            if (resultset.next()){
                String pseudo = resultset.getString("pseudo");
                String email = resultset.getString("email");
                Date birthday = resultset.getDate("birthday");
                int banned = resultset.getInt("banned");
                int isAdmin = resultset.getInt("isAdmin");
                return new User(uid, pseudo, email, birthday, banned, isAdmin);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getUserPassword (int uid) {
        DB myInstance = DB.getInstance();
        String sql = "SELECT password FROM User WHERE idUser = ? ;";
        try ( PreparedStatement state = myInstance.connect.prepareStatement(sql)){
            state.setLong(1, uid);
            ResultSet resultset = state.executeQuery();
            if (resultset.next()){
                return ( resultset.getString("password") );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}