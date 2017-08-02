package com.xellir.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Somehow on 11.07.2017.
 */
@Entity(name = "boardgames" )
@Table(name="boardgames", catalog = "boardgames")
public class Boardgame implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "minNumberOfPlayers")
    private int minNumberOfPlayers;
    @Column(name = "maxNumberOfPlayers")
    private int maxNumberofPlayers;
    @Transient
    private Duration durToken;
    @Column(name = "duration")
    private String duration;
    @Transient
    private Language lanToken;
    @Column(name = "language")
    private String language;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getMinNumberOfPlayers()
    {
        return minNumberOfPlayers;
    }

    public void setMinNumberOfPlayers(int minNumberOfPlayers)
    {
        this.minNumberOfPlayers = minNumberOfPlayers;
    }

    public int getMaxNumberofPlayers()
    {
        return maxNumberofPlayers;
    }

    public void setMaxNumberofPlayers(int maxNumberofPlayers)
    {
        this.maxNumberofPlayers = maxNumberofPlayers;
    }



    public String getDuration()
    {
        return duration;
    }

    public void setDuration(Duration duration)
    {
        this.durToken = duration;
        this.duration = duration.message();
    }




    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(Language language)
    {
        this.lanToken = language;
        this.language = language.message();
    }

    public void getTokensByMessage()
    {
        if (duration.equals(Duration.SHORT.message())) durToken=Duration.SHORT;
        if (duration.equals(Duration.MEDIUM.message())) durToken=Duration.MEDIUM;
        if (duration.equals(Duration.LONG.message())) durToken=Duration.LONG;
        if (duration.equals(Duration.EPIC.message())) durToken=Duration.EPIC;
        if (language.equals(Language.ENGLISH.message())) lanToken=Language.ENGLISH;
        if (language.equals(Language.INDEPENDANT.message())) lanToken=Language.INDEPENDANT;
        if (language.equals(Language.RUSSIAN.message())) lanToken=Language.RUSSIAN;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append("Количество игроков от ");
        stringBuilder.append(minNumberOfPlayers);
        stringBuilder.append(" до ");
        stringBuilder.append(maxNumberofPlayers);
        stringBuilder.append("\n");
        stringBuilder.append("Продолжительность игры: ");
        stringBuilder.append(duration);
        stringBuilder.append("\n");
        stringBuilder.append("Язык: ");
        stringBuilder.append(language);
        return  stringBuilder.toString();
    }
}
