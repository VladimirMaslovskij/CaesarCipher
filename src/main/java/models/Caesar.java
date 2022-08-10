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

    private static final Character[] ALPHABET = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К',
            'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э',
            'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п',
            'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '0', '1', '2', '3',
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
