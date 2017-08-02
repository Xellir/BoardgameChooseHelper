package com.xellir.view;

import com.xellir.Controller.BoardgameController;
import com.xellir.model.Boardgame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * Created by Somehow on 17.07.2017.
 */
public class TestTableManu extends JFrame
{
    private JPanel testPanel;
    private JTable table1;
    private JButton prev;
    private JLabel jl;
    DefaultTableModel tmodel=null;
    BoardgameController controller=new BoardgameController();

    public TestTableManu() throws HeadlessException
    {
        setTitle("Тестовое меню");
        setContentPane(testPanel);

        prev.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                jl.setText((String)table1.getValueAt(table1.getSelectedRow(),0));
            }
        });

    }

    public void showMenu()
    {
        setSize(600,300);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        tmodel=new DefaultTableModel();
        table1.setModel(tmodel);
        java.util.List<Boardgame> ist =controller.allBoardgames();
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
        table1.setRowSelectionInterval(0, 0);


    }

    public static void main(String[] args)
    {
        TestTableManu t=new TestTableManu();
        t.showMenu();

    }
}
