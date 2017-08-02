package com.xellir.view;

import com.xellir.Controller.BoardgameController;
import com.xellir.model.Boardgame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Somehow on 02.08.2017.
 */
public class RandomMenu extends Menu
{
    private JPanel mainPanel;
    private JComboBox number;
    private JButton chooseButton;
    private JLabel message;
    private JButton backButton;
    BoardgameController controller;

    public RandomMenu(Menu previousMenu, final BoardgameController controller)
    {
        this.previousMenu=previousMenu;
        this.controller=controller;
        setTitle("Случайная игра");
        setContentPane(mainPanel);
        showMenu();
        chooseButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int num=Integer.parseInt(String.valueOf(number.getSelectedItem()));
                Boardgame game=controller.chooseBoardgame(num);
                RandomMenu.this.previousMenu.refresh();
                setVisible(false);
                if (game==null) RandomMenu.this.nextMenu=new ErrorMenu(RandomMenu.this,"Такой игры нет",ErrorTitle.ERROR);
                else RandomMenu.this.nextMenu=new ErrorMenu(RandomMenu.this,game.getName(),ErrorTitle.SUCCESS);

            }
        });

        backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                RandomMenu.this.previousMenu.setVisible(true);
                RandomMenu.this.previousMenu.nextMenu=null;
                RandomMenu.this.dispose();
                RandomMenu.this.previousMenu.refresh();
            }
        });
    }

    public void showMenu()
    {
        setDefaultProperties(300,100);
        setVisible(true);
        Integer[] from=new Integer[20];
        for (int i=0;i<20;i++) from[i]=i+1;
        number.setModel(new DefaultComboBoxModel<Integer>(from));
    }
}
