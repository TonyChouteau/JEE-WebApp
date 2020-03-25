package data;
import java.util.ArrayList; // import the ArrayList class
import java.util.Calendar;

/**
 * Représente la BDD des parties en cours GameLine
 */
public class CurrentGames implements CurrentGamesInt {
   ArrayList<GameLine> data ;

    CurrentGames(){
        this.data = new ArrayList<GameLine>();
    }
    /**
     * Ajoute une partie en cours GameLine à la tables des parties en cours.
     * Retourne 1 si l'ajout a fonctionné et 0 sinon.
     * Un ajout échoue si le joueur qu'on ajoute joue déjà à un jeu.
     */
    public int addGame(int idUser, int game){
        GameLine gameLine;
        gameLine = new GameLine(idUser, game);

        for(GameLine tmpgameLine : this.data){//remove previous current games
            if(tmpgameLine.idUser == idUser){
                return 0;
            }
        }

        this.data.add(gameLine);
        return 1;
    }

    /**
     * Retire la partie du joueur idUser de la table des parties en cours et retourne l'objet GameLine à insérer dans la BDD
     */
    public GameLine removeGame(int idUser){//returns first current game to avec user id
        for(GameLine gameLine : this.data){
            if(gameLine.idUser == idUser){
                this.data.remove(gameLine);
                gameLine.gameEndD = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                return gameLine;
            }
        }
        return new GameLine(idUser, -1);
    }
    /**
     * Retourne une arrayList de toutes les parties en cours
     */
    public ArrayList<GameLine> getAllgames(){
        return this.data;
    }


}