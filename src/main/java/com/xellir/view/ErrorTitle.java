package com.xellir.view;

/**
 * Created by Somehow on 17.07.2017.
 */
public enum ErrorTitle
{
    ERROR,
    SUCCESS;

    public String message()
    {
        switch (this)
        {
            case ERROR: return "Ошибка";
            case SUCCESS: return "Успех";

        }
        return null;
    }
}
