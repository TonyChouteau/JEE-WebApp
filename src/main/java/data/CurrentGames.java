package data;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList; // import the ArrayList class
import java.util.Calendar;

/**
 * Représente la BDD des parties en cours GameLine
 */
public class CurrentGames implements CurrentGamesInt {

    private ArrayList<GameLine> data ;
    private static CurrentGames instance;

    public static CurrentGames getInstance() {
        if (instance==null){
            instance = new CurrentGames();
        }
        System.out.println(instance);
        return instance;
    }

    private CurrentGames(){
        this.data = new ArrayList<>();
    }

    /**
     * Ajoute une partie en cours GameLine à la tables des parties en cours.
     * Retourne la GameLine créée si l'ajout a fonctionné et null sinon.
     * Un ajout échoue si le joueur qu'on ajoute joue déjà à un jeu.
     */
    public GameLine addGame(int idUser, int game){
        GameLine gameLine = new GameLine(idUser, game);

        for(GameLine tmpgameLine : this.data){//remove previous current games
            if(tmpgameLine.getIdUser() == idUser){
                return null;
            }
        }

        this.data.add(gameLine);
        return gameLine;
    }

    /**
     * Retire la partie du joueur idUser de la table des parties en cours et retourne l'objet GameLine à insérer dans la BDD
     */
    public GameLine removeGame(int idUser){//returns first current game to avec user id
        for(GameLine gameLine : this.data){
            if(gameLine.getIdUser() == idUser){
                this.data.remove(gameLine);
                gameLine.setGameEndD(new Timestamp(Calendar.getInstance().getTime().getTime()));
                return gameLine;
            }
        }
        return new GameLine(idUser, -1);
    }

    @Override
    public GameLine getGame(int uid) {
        for(GameLine gameLine : this.data){
            if(gameLine.getIdUser() == uid){
                return gameLine;
            }
        }
        return null;
    }

    /**
     * Retourne une arrayList de toutes les parties en cours
     */
    public ArrayList<GameLine> getAllgames(){
        return this.data;
    }


}