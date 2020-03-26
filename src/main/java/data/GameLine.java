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
    private Timestamp gameBeginD;
    private Timestamp gameEndD;

    GameLine(int idUser, int game){
        this.idUser = idUser;
        this.game = game;
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