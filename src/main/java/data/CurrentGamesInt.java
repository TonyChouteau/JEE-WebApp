package data;

import java.util.ArrayList;
import java.util.HashMap;

public interface CurrentGamesInt {
    GameLine addGame(int idUser, int idGame, String un, String gn);

    GameLine removeGame(int idUser);
    HashMap<Integer, Integer> getNbJoueurs ();

    GameLine getGame (int uid);
    ArrayList<GameLine> getAllgames();//retourne toutes les lignes 
}