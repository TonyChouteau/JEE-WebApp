package data;

import java.util.ArrayList;

public interface CurrentGamesInt {
    int addGame(int idUser, int idGame);

    GameLine removeGame(int idUser); 
    
    ArrayList<GameLine> getAllgames();//retourne toutes les lignes 
}