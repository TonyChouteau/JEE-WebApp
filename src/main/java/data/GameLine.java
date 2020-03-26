package data;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
/**
 * Représente une partie en cours
 * à insérer dans la BDD sql lorsque la partie est terminée
 */
public class GameLine{
    private int idUser;
    private int game;
    private String username;
    private String gamename;
    private Timestamp gameBeginD;
    private Timestamp gameEndD;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    GameLine(int idUser, int game, String un, String gn){
        this.idUser = idUser;
        this.game = game;
        this.username = un;
        this.gamename = gn;
        this.gameBeginD = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public Timestamp getGameBeginD() {
        return gameBeginD;
    }

    public void setGameBeginD(Timestamp gameBeginD) {
        this.gameBeginD = gameBeginD;
    }

    public Timestamp getGameEndD() {
        return gameEndD;
    }

    public void setGameEndD(Timestamp gameEndD) {
        this.gameEndD = gameEndD;
    }
}