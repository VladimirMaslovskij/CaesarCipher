import dao.CaesarDAO;
import decoding.BruteForce;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.util.ArrayList;

public class BruteForceTest {
    Path path;
    Path path2;

    CaesarDAO caesarDAO;

    @Before
    public void initPaths() {
        path = Path.of("Text1_kgr.txt");
        caesarDAO = new CaesarDAO();
    }

    @Test
    public void decryptTest()
    {
        ArrayList<String> encryptedFile = caesarDAO.readFile(path);
        ArrayList<String> hackedText = BruteForce.hackText(encryptedFile);
        for (String str : hackedText)
            System.out.println(str);
    }
}
