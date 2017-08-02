package com.xellir.view;

import com.xellir.Controller.BoardgameMySQLController;
import com.xellir.model.Boardgame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Somehow on 13.07.2017.
 */
public class TestMenu extends JFrame
{
    MainMenu menu;
    private JPanel testPanel;
    private JButton prev;
    DefaultListModel<String> smodel=new DefaultListModel();
    DefaultTableModel tmodel=null;
    private JList list1;
    private JButton check;
    private JLabel checkField;
    private JTable table1;

    BoardgameMySQLController controller=new BoardgameMySQLController();

    public TestMenu(final MainMenu m)
    {
        this.menu=m;
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setModel(smodel);



        setTitle("Тестовое меню");
        setContentPane(testPanel);

        prev.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                menu.showMenu();
                dispose();
            }
        });

        check.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //smodel.addElement("Луноход 3");
                checkField.setText((String) list1.getSelectedValue());
            }
        });
    }

    public void showMenu()
    {
        setSize(400,400);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        smodel.clear();

        List<Boardgame> ist =controller.allBoardgames();
        String[] names=new String[ist.size()];
        int i=0;
        tmodel=new DefaultTableModel();
        table1.setModel(tmodel);
        for (Boardgame b:ist
                )

        {
            smodel.addElement(b.getName());
            names[i]=b.getName();
            i++;

        }
        list1.setSelectedIndex(0);
        tmodel.addColumn("Название", names);

    }


}
