package com.xellir.view;

import com.xellir.Controller.BoardgameController;
import com.xellir.Controller.BoardgameMySQLController;
import com.xellir.model.Boardgame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Somehow on 18.07.2017.
 */
public class DeleteMenu extends Menu
{
    private JPanel mainPanel;
    private JLabel message;
    private JButton yes;
    private JButton no;
    private JLabel gameName;
    private BoardgameController controller;
    private Boardgame game;

    public DeleteMenu(Menu previousMenu, final BoardgameController controller, final Boardgame game)
    {
        this.previousMenu=previousMenu;
        this.controller=controller;
        this.game=game;
        setTitle("Удаление");
        gameName.setText(this.game.getName()+"?");
        setContentPane(mainPanel);
        showMenu();


    }

    public void showMenu()
    {
        setDefaultProperties(200,110);
        message.setText("Вы точно хотите удалить игру:");
        setVisible(true);
        no.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                DeleteMenu.this.previousMenu.setVisible(true);
                DeleteMenu.this.previousMenu.nextMenu=null;
                DeleteMenu.this.dispose();
                DeleteMenu.this.previousMenu.refresh();
            }
        });
        yes.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.removeBoardgame(game);
                DeleteMenu.this.previousMenu.refresh();
                DeleteMenu.this.nextMenu=new ErrorMenu(DeleteMenu.this.previousMenu,"Удалено",ErrorTitle.SUCCESS);
                DeleteMenu.this.dispose();
                return;
            }
        });

    }

    public static void main(String[] args)
    {
        //new DeleteMenu();
    }
}
