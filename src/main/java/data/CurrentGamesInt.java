package data;

import java.util.ArrayList;

public interface CurrentGamesInt {
    GameLine addGame(int idUser, int idGame, String un, String gn);

    GameLine removeGame(int idUser);
    ArrayList<Integer> getNbJoueurs ();

    GameLine getGame (int uid);
    ArrayList<GameLine> getAllgames();//retourne toutes les lignes 
}