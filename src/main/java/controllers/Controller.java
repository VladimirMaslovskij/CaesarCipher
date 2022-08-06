package controllers;

import dao.CaesarDAO;
import decoding.BruteForce;
import models.Caesar;

import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller
{
    public static void main(String[] args)
    {
        ArrayList<String> workingList = new ArrayList<>();
        CaesarDAO caesarDAO = new CaesarDAO();
        Scanner sc = new Scanner(System.in);
        printInterface();
        boolean isExit = false;
        while (!isExit)
        {
            switch (sc.nextInt())
            {

                case 1:
                case 4:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Input the file path:");
                    Path path = Path.of(scanner.nextLine());
                    workingList = caesarDAO.readFile(path);
                    System.out.println("Text in this file: " + "\n");
                    caesarDAO.printFile(workingList);
                    printInterface();
                    break;
                case 2:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Input the key: ");
                    int key = scanner1.nextInt();
                    workingList = caesarDAO.encrypt(key, workingList);
                    System.out.println("Encrypted text: " + "\n");
                    caesarDAO.printFile(workingList);
                    printInterface();
                    break;
                case 3:
                case 6:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Input the file path:");
                    Path path1 = Path.of(scanner2.nextLine());
                    caesarDAO.writeFile(workingList, path1);
                    System.out.println("File has been saved " + "\n");
                    printInterface();
                    break;
                case 5:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Input the key: ");
                    int key1 = scanner3.nextInt();
                    workingList = caesarDAO.decrypt(key1, workingList);
                    System.out.println("Encrypted text: " + "\n");
                    caesarDAO.printFile(workingList);
                    printInterface();
                    break;
                case 7:
                    System.out.println("Hacking encrypted text witch brute force: " + "\n");
                    workingList = BruteForce.hackText(workingList);
                    System.out.println("Encrypted text: " + "\n");
                    caesarDAO.printFile(workingList);
                    printInterface();
                    break;
                case 8:
                    isExit = true;
                    break;
            }
        }
    }

    public static void printInterface()
    {
        System.out.println("!!!!!!!!!!!! MENU OF CAESAR CIPHER !!!!!!!!!!!!" + "\n");
        System.out.println("1. Read the opened text from file" + "\n" +
                "2. Encrypt selected file" + "\n" +
                "3. Save the closed text to file" + "\n" +
                "4. Read the closed text from file" + "\n" +
                "5. Decrypt selected file" + "\n" +
                "6. Save the opened text to file" + "\n" +
                "7. Hack the file" + "\n" +
                "8. Finish the program." + "\n" + "\n");
    }
}
