package dao;

import models.Caesar;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class CaesarDAO
{
    private final Caesar caesar = Caesar.getInstance();

    public final Caesar getCaesar()
    {
        return caesar;
    }

    public ArrayList<String> readFile(Path path)
    {
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path))))
        {
            while (reader.ready())
            {
                String str = reader.readLine();
                list.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void writeFile(ArrayList<String> list, Path path)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(path))))
        {
            for (String str : list)
            {
                writer.write(str + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> encrypt(int key, ArrayList<String> openText)
    {
        Character[] alphabet = Caesar.getAlphabet();
        ArrayList<String> closedText = new ArrayList<>();
        for (String str : openText)
        {
            StringBuilder stringBuilder = new StringBuilder();
            char[] openString = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                char sym = 'W';
                for (int j = 0; j < alphabet.length; j++) {
                    if (openString[i] == alphabet[j])
                    {
                        if (j + key < alphabet.length)
                        sym = alphabet[j + key];
                        else sym = alphabet[(j + key) % alphabet.length];
                    }
                }
                stringBuilder.append(sym);
            }
            closedText.add(String.valueOf(stringBuilder));
        }
        return closedText;
    }

    public ArrayList<String> decrypt(int key, ArrayList<String> closedText)
    {
        Character[] alphabet = Caesar.getAlphabet();
        ArrayList<String> openText = new ArrayList<>();
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
                        else if (key - j != alphabet.length)
                            sym = alphabet[alphabet.length - ((key - j) % alphabet.length)];
                        else if (key - j == alphabet.length)
                            sym = alphabet[alphabet.length - 1];
                    }
                }
                stringBuilder.append(sym);
            }
            openText.add(String.valueOf(stringBuilder));
        }
        return openText;
    }

    public void printFile(ArrayList<String> list)
    {
        for (String str : list)
            System.out.println(str);
        System.out.println("");
    }
}
