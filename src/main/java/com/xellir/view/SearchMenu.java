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
 * Created by Somehow on 02.08.2017.
 */
public class SearchMenu extends Menu
{
    private JPanel mainPanel;
    private JTextField searchField;
    private JButton searchButton;
    private JTable searchTable;
    private JButton editButton;
    private JButton deleteButton;
    private JButton backButton;
    private JScrollPane scroll;
    DefaultTableModel tmodel=null;
    BoardgameController controller;

    public SearchMenu(Menu previousMenu, final BoardgameController controller)
    {
        this.previousMenu=previousMenu;
        this.controller=controller;
        setTitle("Поиск");
        setContentPane(mainPanel);
        showMenu();

        searchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                refresh();
            }
        });

        editButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                nextMenu=new AddOrUpdateMenu(SearchMenu.this,controller,getBoardgame());
                return;
            }
        });

        deleteButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                nextMenu=new DeleteMenu(SearchMenu.this,controller,getBoardgame());
                return;
            }
        });
        backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                SearchMenu.this.previousMenu.setVisible(true);
                SearchMenu.this.previousMenu.nextMenu=null;
                SearchMenu.this.dispose();
                SearchMenu.this.previousMenu.refresh();
            }
        });
    }

    public void showMenu()
    {
        setDefaultProperties(600,300);
        setVisible(true);
    }

    @Override
    protected void refresh()
    {
        tmodel=new DefaultTableModel();
        searchTable.setModel(tmodel);
        String searchValue=searchField.getText();
        if (searchValue==null) searchValue="";
        final List<Boardgame> ist =controller.searchBoardgame(searchValue);
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
        if (searchTable.getRowCount()>0) searchTable.setRowSelectionInterval(0, 0);
    }

    private Boardgame getBoardgame()
    {
        String gameName=(String)searchTable.getValueAt(searchTable.getSelectedRow(),0);
        String gameDuration=(String)searchTable.getValueAt(searchTable.getSelectedRow(),1);;
        String gameLanguage=(String)searchTable.getValueAt(searchTable.getSelectedRow(),3);;
        String[] gameLen=((String)searchTable.getValueAt(searchTable.getSelectedRow(),2)).split(" ");


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
}
