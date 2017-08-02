package com.xellir.model;


public enum Duration
{
    SHORT,
    MEDIUM,
    LONG,
    EPIC;

     public String message()
    {
        switch (this)
        {
            case SHORT: return "Филлер";
            case MEDIUM: return "Средняя";
            case LONG: return "Долгая";
            case EPIC: return "Очень долгая";
        }
        return null;
    }

    public static Duration messageToDuration(String dur)
    {
        if (dur.equals(SHORT.message())) return Duration.SHORT;
        if (dur.equals(MEDIUM.message())) return Duration.MEDIUM;
        if (dur.equals(LONG.message())) return Duration.LONG;
        if (dur.equals(EPIC.message())) return Duration.EPIC;
        return null;
    }
}
