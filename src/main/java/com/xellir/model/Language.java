package com.xellir.model;

/**
 * Created by Somehow on 11.07.2017.
 */
public enum Language
{
    RUSSIAN,
    INDEPENDANT,
    ENGLISH;

    public String message()
    {
        switch (this)
        {
            case RUSSIAN:return "Руссифицирована";
            case INDEPENDANT: return "Языконезависима";
            case ENGLISH: return "Английская";
        }
        return null;

    }

    public static Language messageToLanguage(String lan)
    {
        if (lan.equals(RUSSIAN.message())) return Language.RUSSIAN;
        if (lan.equals(INDEPENDANT.message())) return Language.INDEPENDANT;
        if (lan.equals(ENGLISH.message())) return Language.ENGLISH;
        return null;
    }
}
