package com.xellir.Controller;

import com.xellir.model.Boardgame;

import java.util.List;

/**
 * Created by Somehow on 02.08.2017.
 */
public interface BoardgameController
{
    public void addBoardgame(Boardgame game);
    public void removeBoardgame(Boardgame game);
    public void updateBoardgame(Boardgame game);
    public Boardgame chooseBoardgame(int numberOfPlayers);
    public List<Boardgame> allBoardgames();
    public List<Boardgame> searchBoardgame(String name);
}
