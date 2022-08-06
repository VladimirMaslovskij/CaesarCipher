package models;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class Caesar
{
    private static Caesar INSTANCE = null;

    public static Caesar getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new Caesar();
        return INSTANCE;
    }

    private Caesar() {}

    private static ArrayList<String> openText = new ArrayList<>();
    private static ArrayList<String> closedText = new ArrayList<>();

    private static final Character[] ALPHABET = {'А', 'а', 'Б', 'б', 'В', 'в', 'Г', 'г', 'Д', 'д', 'Е', 'е',
            'Ё', 'ё', 'Ж', 'ж', 'З', 'з', 'И', 'и', 'Й', 'й', 'К', 'к', 'Л', 'л', 'М', 'м', 'Н', 'н', 'О',
            'о', 'П', 'п', 'Р', 'р', 'С', 'с', 'Т', 'т', 'У', 'у', 'Ф', 'ф', 'Х', 'х', 'Ц', 'ц', 'Ч', 'ч',
            'Ш', 'ш', 'Щ', 'щ', 'Ъ', 'ъ', 'Ы', 'ы', 'Ь', 'ь', 'Э', 'э', 'Ю', 'ю', 'Я', 'я', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '.', ',', '!', '?', ':', '-', ';',  '(', ')', ' ', '"', '+', '_', '='};


    public static Character[] getAlphabet()
    {
        return ALPHABET;
    }

    public static ArrayList<String> getOpenText()
    {
        return openText;
    }

    public static void setOpenText(ArrayList<String> openText)
    {
        Caesar.openText = openText;
    }

    public static ArrayList<String> getClosedText()
    {
        return closedText;
    }

    public static void setClosedText(ArrayList<String> closedText)
    {
        Caesar.closedText = closedText;
    }
}
