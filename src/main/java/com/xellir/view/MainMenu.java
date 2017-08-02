package com.xellir.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Somehow on 13.07.2017.
 */
public class MainMenu extends JFrame
{
    private JButton boardgameList;
    private JPanel mainPanel;
    private TestMenu nextMenu;

    public MainMenu() throws HeadlessException
    {
        setContentPane(mainPanel);
        setTitle("Главное меню");
        showMenu();
        nextMenu=new TestMenu(this);
        boardgameList.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                nextMenu.showMenu();
            }
        });
    }

    public void showMenu()
    {
        setSize(300,300);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new MainMenu();
    }


}
