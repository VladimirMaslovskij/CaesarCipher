import dao.CaesarDAO;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.util.ArrayList;

public class CaesarDAOTest
{
    CaesarDAO caesarDAO;
    Path path;
    Path path2;
    Path path3;

    @Before
    public void initCaesarDAO()
    {
        caesarDAO = new CaesarDAO();
        path = Path.of("Text1.txt");
        path2 = Path.of("Text1_kgr.txt");
        path3 = Path.of("Text1_unkgr.txt");
    }

    @Test
    public void encryptTest()
    {
        ArrayList<String> openFile = caesarDAO.readFile(path);
        System.out.println("Open text");
        for (String str : openFile)
            System.out.println(str);
        System.out.println("");
        ArrayList<String> closedFile = caesarDAO.encrypt(1000, openFile);
        System.out.println("closed text");
        for (String str : closedFile)
            System.out.println(str);
        System.out.println("");
        caesarDAO.writeFile(closedFile, path2);
        System.out.println("file was written");
    }

    @Test
    public void decryptTest()
    {
        ArrayList<String> encryptedFile = caesarDAO.readFile(path2);
        System.out.println("Encrypted file");
        for (String str : encryptedFile)
            System.out.println(str);
        System.out.println("");
        ArrayList<String> decryptedFile = caesarDAO.decrypt(1000, encryptedFile);
        System.out.println("Decrypted file");
        for (String str : decryptedFile)
            System.out.println(str);
        System.out.println("");
        caesarDAO.writeFile(decryptedFile, path3);
        System.out.println("file was written");
    }
}
