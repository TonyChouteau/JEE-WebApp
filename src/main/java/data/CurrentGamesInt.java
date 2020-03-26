package data;

import java.util.ArrayList;

public interface CurrentGamesInt {
    GameLine addGame(int idUser, int idGame);

    GameLine removeGame(int idUser); 

    GameLine getGame (int uid);

    ArrayList<GameLine> getAllgames();//retourne toutes les lignes 
}