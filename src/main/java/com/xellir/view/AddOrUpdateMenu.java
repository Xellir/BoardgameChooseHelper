package com.xellir.view;

import com.xellir.Controller.BoardgameController;
import com.xellir.model.Boardgame;
import com.xellir.model.Duration;
import com.xellir.model.Language;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Somehow on 17.07.2017.
 */
public class AddOrUpdateMenu extends Menu
{
    private JTextField nameField;
    private JComboBox fromBox;
    private JComboBox toBox;
    private JComboBox durationBox;
    private JComboBox languageBox;
    private JButton add;
    private JButton back;
    private JPanel mainPanel;
    private BoardgameController controller;

    public AddOrUpdateMenu(Menu previousMenu, BoardgameController controller)
    {
        this.previousMenu=previousMenu;
        this.controller=controller;
        setTitle("Добавление");
        setContentPane(mainPanel);
        showMenu();
        add.setText("Добавить");

        add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                if ((nameField.getText().equals(""))||(nameField.getText()==null))
                {
                    setVisible(false);
                    nextMenu=new ErrorMenu(AddOrUpdateMenu.this,"Введите название",ErrorTitle.ERROR);
                    return;
                }
                else {
                    Boardgame boardgame=new Boardgame();
                    boardgame.setName(nameField.getText());
                    int fromP=Integer.parseInt(String.valueOf(fromBox.getSelectedItem()));
                    int toP=Integer.parseInt(String.valueOf(toBox.getSelectedItem()));
                    if (toP<fromP) toP=fromP;
                    boardgame.setMinNumberOfPlayers(fromP);
                    boardgame.setMaxNumberofPlayers(toP);
                    boardgame.setDuration(Duration.messageToDuration(String.valueOf(durationBox.getSelectedItem())));
                    boardgame.setLanguage(Language.messageToLanguage(String.valueOf(languageBox.getSelectedItem())));
                    AddOrUpdateMenu.this.controller.addBoardgame(boardgame);
                    nextMenu=new ErrorMenu(AddOrUpdateMenu.this,"Игра добавлена",ErrorTitle.SUCCESS);
                }
            }
        });
    }

    public AddOrUpdateMenu(Menu previousMenu, BoardgameController controller, final Boardgame game)
    {
        this.previousMenu=previousMenu;
        this.controller=controller;
        setTitle("Редактирование");
        setContentPane(mainPanel);
        showMenu();
        add.setText("Изменить");
        fromBox.setSelectedItem(game.getMinNumberOfPlayers());
        toBox.setSelectedItem(game.getMaxNumberofPlayers());
        nameField.setText(game.getName());
        durationBox.setSelectedItem(game.getDuration());
        languageBox.setSelectedItem(game.getLanguage());

        add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                if ((nameField.getText().equals(""))||(nameField.getText()==null))
                {
                    setVisible(false);
                    nextMenu=new ErrorMenu(AddOrUpdateMenu.this,"Введите название",ErrorTitle.ERROR);
                    return;
                }
                else {
                    Boardgame boardgame=game;
                    boardgame.setName(nameField.getText());
                    int fromP=Integer.parseInt(String.valueOf(fromBox.getSelectedItem()));
                    int toP=Integer.parseInt(String.valueOf(toBox.getSelectedItem()));
                    if (toP<fromP) toP=fromP;
                    boardgame.setMinNumberOfPlayers(fromP);
                    boardgame.setMaxNumberofPlayers(toP);
                    boardgame.setDuration(Duration.messageToDuration(String.valueOf(durationBox.getSelectedItem())));
                    boardgame.setLanguage(Language.messageToLanguage(String.valueOf(languageBox.getSelectedItem())));
                    AddOrUpdateMenu.this.controller.updateBoardgame(boardgame);
                    nextMenu=new ErrorMenu(AddOrUpdateMenu.this,"Игра изменена",ErrorTitle.SUCCESS);
                }
            }
        });
    }

    public void showMenu()
    {
        setDefaultProperties(380,200);
        setVisible(true);
        Integer[] from=new Integer[20];
        for (int i=0;i<20;i++) from[i]=i+1;
        fromBox.setModel(new DefaultComboBoxModel<Integer>(from));
        toBox.setModel(new DefaultComboBoxModel<Integer>(from));
        final String[] duration={Duration.SHORT.message(),Duration.MEDIUM.message(),
        Duration.LONG.message(),Duration.EPIC.message()};
        durationBox.setModel(new DefaultComboBoxModel(duration));
        final String[] language={Language.ENGLISH.message(),
                Language.INDEPENDANT.message(),Language.RUSSIAN.message()};
        languageBox.setModel(new DefaultComboBoxModel(language));



        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AddOrUpdateMenu.this.previousMenu.setVisible(true);
                AddOrUpdateMenu.this.previousMenu.nextMenu=null;
                AddOrUpdateMenu.this.dispose();
                AddOrUpdateMenu.this.previousMenu.refresh();
            }
        });


    }

    public static void main(String[] args)
    {
       //new AddOrUpdateMenu();
    }
}
