package com.xellir;

import com.xellir.Controller.BoardgameMySQLController;
import com.xellir.model.Boardgame;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //new MainMenu();
       // System.out.println(Duration.EPIC.message().length());
        BoardgameMySQLController controller=new BoardgameMySQLController();
        List<Boardgame> list = controller.allBoardgames();
        for (Boardgame b:list
             )
        {
            System.out.println(b);
        }
        //controller.addBoardgame("Battlestar Galactica",3,7,Duration.LONG,Language.ENGLISH);
        //controller.addBoardgame("Dungeon lords",2,4,Duration.LONG,Language.ENGLISH);
        //controller.addBoardgame("Roborally",2,8,Duration.LONG,Language.ENGLISH);
        //controller.chooseBoardgame(6);
        controller.shutdown();
    }
}
