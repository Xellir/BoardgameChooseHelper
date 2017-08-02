package com.xellir.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Somehow on 17.07.2017.
 */
public class ErrorMenu extends Menu
{
    private JButton okButton;
    private JLabel error;
    private JPanel mainPanel;

    public ErrorMenu(Menu previousMenu,String message,ErrorTitle title)
    {
        this.previousMenu=previousMenu;
        setTitle(title.message());
        setContentPane(mainPanel);
        error.setText(message);

        showMenu();
    }

    public void showMenu()
    {
        setDefaultProperties(100,100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        okButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ErrorMenu.this.previousMenu.setVisible(true);
                ErrorMenu.this.previousMenu.nextMenu=null;
                ErrorMenu.this.dispose();

            }
        });
        setVisible(true);


    }

    public static void main(String[] args)
    {
       // new ErrorMenu("Веедите название");
    }
}
