package data;

import java.sql.Date;
import java.util.Calendar;
/**
 * Représente une partie en cours
 * à insérer dans la BDD sql lorsque la partie est terminée
 */
public class GameLine{
    private int idUser;
    private int game;
    private Date gameBeginD;
    private Date gameEndD;

    GameLine(int idUser, int game){
        this.idUser = idUser;
        this.game = game;
        this.gameBeginD = new java.sql.Date(Calendar.getInstance().getTime().getTime());
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

    public Date getGameBeginD() {
        return gameBeginD;
    }

    public void setGameBeginD(Date gameBeginD) {
        this.gameBeginD = gameBeginD;
    }

    public Date getGameEndD() {
        return gameEndD;
    }

    public void setGameEndD(Date gameEndD) {
        this.gameEndD = gameEndD;
    }
}