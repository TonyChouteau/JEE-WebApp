package data;

import java.sql.Date;
import java.util.Calendar;
/**
 * Représente une partie en cours
 * à insérer dans la BDD sql lorsque la partie est terminée
 */
public class GameLine{
    public int idUser;
    public int game;
    public Date gameBeginD;
    public Date gameEndD;

    GameLine(int idUser, int game){
        this.idUser = idUser;
        this.game = game;
        this.gameBeginD = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        this.gameEndD = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    }
}