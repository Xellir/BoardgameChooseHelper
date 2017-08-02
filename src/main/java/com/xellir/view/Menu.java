package com.xellir.view;

import org.hibernate.annotations.SourceType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Somehow on 17.07.2017.
 */
abstract class Menu extends JFrame
{
    protected Menu previousMenu;
    protected Menu nextMenu;

    public abstract void showMenu();
    public void setDefaultProperties(int width,int height)
    {
        setSize(width,height);
        setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setDefaultProperties()
    {
        setDefaultProperties(300,300);
    }

    protected void refresh()
    {
        System.out.println("Метод не поддерживается");
    }
}
