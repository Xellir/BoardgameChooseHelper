package com.xellir;

import com.xellir.Controller.BoardgameController;
import com.xellir.model.Boardgame;
import com.xellir.model.Duration;
import com.xellir.model.Language;
import com.xellir.view.MainMenu;

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
        BoardgameController controller=new BoardgameController();
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
