package com.xellir.Controller;

import com.xellir.model.Boardgame;
import com.xellir.model.Duration;
import com.xellir.model.Language;
import org.hibernate.FlushMode;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Somehow on 11.07.2017.
 */
public class BoardgameMySQLController implements BoardgameController
{
    private static Session session;

    public BoardgameMySQLController()
    {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    public void addBoardgame(Boardgame game)
    {
        System.out.println(session.getFlushMode());
        session.beginTransaction();
        session.save(game);
        session.getTransaction().commit();
        //session.getTransaction().commit();



    }

    public void removeBoardgame(Boardgame game)
    {
        session.beginTransaction();
        session.remove(game);
       // session.flush();
        session.getTransaction().commit();


    }

    public void updateBoardgame(Boardgame game)
    {
        session.beginTransaction();
        session.saveOrUpdate(game);
       // session.flush();
       session.getTransaction().commit();



    }

    public Boardgame chooseBoardgame(int numberOfPlayers)
    {
        session.beginTransaction();
        List<Boardgame> list=(List<Boardgame>)session.createQuery
                ("from boardgames where minNumberOfPlayers<='"+numberOfPlayers+"' " +
                         "and maxNumberOfPlayers>='"+numberOfPlayers+"'").list();
        //session.flush();
        session.getTransaction().commit();


        ArrayList<Boardgame>aList=new ArrayList<Boardgame>(list);
        if (list.size()>0)
        {
            Random random = new Random();
            Boardgame result = aList.get(random.nextInt(aList.size()));
            result.getTokensByMessage();
            //System.out.println(result);
            return result;
        }
        return null;
    }

    public List<Boardgame> allBoardgames()
    {
        session.beginTransaction();
        List<Boardgame> list=(List<Boardgame>)session.createQuery("from boardgames").list();
        session.getTransaction().commit();


        return list;
    }

    public List<Boardgame> searchBoardgame(String name)
    {
        List<Boardgame> result=new ArrayList<Boardgame>();
        List<Boardgame> check=allBoardgames();
        for (Boardgame b:check
             )
        {
            if (b.getName().contains(name)) result.add(b);
        }
        return result;
    }

    public void shutdown()
    {
        session.getSessionFactory().close();
        session.close();
    }

}
