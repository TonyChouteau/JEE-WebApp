package data;
import java.util.ArrayList; // import the ArrayList class

public class CurrentGames implements CurrentGamesInt {
   ArrayList<GameLine> data ;

    CurrentGames(){
        this.data = new ArrayList<GameLine>();
    }

    public int addGame(int idUser, int game){
        GameLine gameLine;
        gameLine = new GameLine(idUser, game);

        for(GameLine tmpgameLine : this.data){//remove previous current games
            if(tmpgameLine.idUser == idUser){
                this.data.remove(gameLine);
            }
        }

        this.data.add(gameLine);
        return 1;
    }

    public GameLine removeGame(int idUser){//returns first current game to avec user id
        for(GameLine gameLine : this.data){
            if(gameLine.idUser == idUser){
                this.data.remove(gameLine);
                return gameLine;
            }
        }
        return new GameLine(idUser, -1);
    }

    public ArrayList<GameLine> getAllgames(){
        return this.data;
    }


}