package com.xellir.view;

import com.xellir.Controller.BoardgameController;
import com.xellir.Controller.BoardgameMySQLController;
import com.xellir.model.Boardgame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Somehow on 17.07.2017.
 */
public class listMenu extends Menu
{
    private JPanel listPanel;
    private JTable boargamesTable;
    private JButton edit;
    private JButton delete;
    private JButton add;
    private JButton search;
    private JButton random;
    DefaultTableModel tmodel=null;
    BoardgameController controller=new BoardgameMySQLController();

    public listMenu()
    {
        setTitle("Главное меню");
        setContentPane(listPanel);

        add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                nextMenu=new AddOrUpdateMenu(listMenu.this,controller);
                return;
            }
        });

        delete.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                setVisible(false);
                nextMenu=new DeleteMenu(listMenu.this,controller,getBoardgame());
                return;
            }
        });

        edit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                setVisible(false);
                nextMenu=new AddOrUpdateMenu(listMenu.this,controller,getBoardgame());
                return;
            }
        });
        showMenu();
        search.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                nextMenu=new SearchMenu(listMenu.this,controller);
                return;
            }
        });

        random.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                nextMenu=new RandomMenu(listMenu.this,controller);
                return;
            }
        });

    }

    @Override
    protected void refresh()
    {
        tmodel=new DefaultTableModel();
        boargamesTable.setModel(tmodel);
        final List<Boardgame> ist =controller.allBoardgames();
        String[] names=new String[ist.size()];
        String[] durations = new  String[ist.size()];
        String[] numOfPlayers=new String[ist.size()];
        String[] language=new String[ist.size()];
        int i=0;
        for (Boardgame b:ist
                )

        {
            names[i]=b.getName();
            durations[i]=b.getDuration();
            numOfPlayers[i]="от "+b.getMinNumberOfPlayers()+" до "+b.getMaxNumberofPlayers();
            language[i]=b.getLanguage();
            i++;

        }
        tmodel.addColumn("Название", names);
        tmodel.addColumn("Длительность", durations);
        tmodel.addColumn("Количество игроков", numOfPlayers);
        tmodel.addColumn("Языкозависимость", language);
        boargamesTable.setRowSelectionInterval(0, 0);


    }

    private Boardgame getBoardgame()
    {
        String gameName=(String)boargamesTable.getValueAt(boargamesTable.getSelectedRow(),0);
        String gameDuration=(String)boargamesTable.getValueAt(boargamesTable.getSelectedRow(),1);;
        String gameLanguage=(String)boargamesTable.getValueAt(boargamesTable.getSelectedRow(),3);;
        String[] gameLen=((String)boargamesTable.getValueAt(boargamesTable.getSelectedRow(),2)).split(" ");


        List<Boardgame> ist =controller.allBoardgames();
        for (Boardgame b:ist
                )

        {
            if ((b.getName().equals(gameName))
                    &&(b.getDuration().equals(gameDuration))
                    &&(b.getLanguage().equals(gameLanguage))
                    &&(b.getMinNumberOfPlayers()==Integer.parseInt(gameLen[1]))
                    &&(b.getMaxNumberofPlayers()==Integer.parseInt(gameLen[3])))
            {
                return b;

            }

        }
        return null;
    }

    public void showMenu()
    {
        setDefaultProperties(600,300);
        refresh();
        setVisible(true);


        

    }

    public static void main(String[] args)
    {
        new listMenu();
    }
}
