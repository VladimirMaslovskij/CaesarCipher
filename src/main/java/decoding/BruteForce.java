package decoding;

import models.Caesar;

import java.util.ArrayList;

public class BruteForce
{
    private static Caesar caesar = Caesar.getInstance();
    private static Character[] alphabet = Caesar.getAlphabet();

    public static ArrayList<String> hackText(ArrayList<String> closedText)
    {
        ArrayList<String> text = new ArrayList<>();
        String string = "Условие не выполнено, все говно";
        text.add(string);
        ArrayList<String> result = new ArrayList<>();
        boolean isDecode = false;
        for (int i = 0; i <= alphabet.length; i++)
        {
            result = tryHack(closedText, i);
            if (checkDecode(result) == true)
            {
                isDecode = true;
                break;
            }
        }
        if (isDecode)
        return result;
        else return text;
    }

    public static ArrayList<String> tryHack(ArrayList<String> closedText, int key)
    {
        ArrayList<String> maybeHackedText = new ArrayList<>();
        for (String str : closedText)
        {
            StringBuilder stringBuilder = new StringBuilder();
            char[] closedString = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                char sym = 'W';
                for (int j = 0; j < alphabet.length; j++) {
                    if (closedString[i] == alphabet[j])
                    {
                        if (j - key >= 0)
                            sym = alphabet[j - key];
                        else if ((key - j) % alphabet.length != 0)
                            sym = alphabet[alphabet.length - ((key - j) % alphabet.length)];
                        else if ((key - j) % alphabet.length == 0)
                            sym = alphabet[alphabet.length - 1];
                    }
                }
                stringBuilder.append(sym);
            }
            maybeHackedText.add(String.valueOf(stringBuilder));
        }
        return maybeHackedText;
    }

    private static boolean checkDecode(ArrayList<String> maybeHackedText) {
        StringBuilder builder = new StringBuilder();
        boolean firstTest = false;
        boolean secondTest = false;
        for (String str : maybeHackedText)
            builder.append(str);
        StringBuilder newBuilder = new StringBuilder(builder.substring(0, builder.length() - 2));
        char[] textArray = newBuilder.toString().toCharArray();
        for (int i = 1; i < textArray.length; i++) {
            if (textArray[i - 1] == ',' || textArray[i - 1] == ';' || textArray[i - 1] == '.' ||
                textArray[i - 1] == '!' || textArray[i - 1] == '?')
            {
                if (textArray[i] == ' ')
                    firstTest = true;
            }
        }
        if (builder.toString().endsWith(".") || builder.toString().endsWith("!") || builder.toString().endsWith("?") )
            secondTest = true;
        if (firstTest == true && secondTest == true)
            return true;
        else return false;
    }
}
