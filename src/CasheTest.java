import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CasheTest {
    Cashe cashe = new Cashe();

    @Test
    public void displayAllRankings() {
        ArrayList<ProcessingData.IndexRanking> actual =
                cashe.loadCashe("SocialRankings_test.txt");
        cashe.displayAllRankings(actual);
        assertEquals(5, actual.size());
    }

    @Test
    public void checkFile() {
        saveLocal();
        boolean actual = cashe.checkFile("SocialRankings_test.txt");
        assertTrue(actual);
    }
    @Test
    public void saveLocal() {
        ArrayList<ProcessingData.IndexRanking> example = new ArrayList<>();
        ProcessingData pd = new ProcessingData();
        ProcessingData.IndexRanking idx1 =
                new ProcessingData.IndexRanking(1.1, "USA");
        ProcessingData.IndexRanking idx2 =
                new ProcessingData.IndexRanking(1.5, "Norway");
        ProcessingData.IndexRanking idx3 =
                new ProcessingData.IndexRanking(2.5, "Switzerland");
        ProcessingData.IndexRanking idx4 =
                new ProcessingData.IndexRanking(4.7, "Denmark");
        ProcessingData.IndexRanking idx5 =
                new ProcessingData.IndexRanking(7.8, "Germany");
        example.add(idx1);
        example.add(idx2);
        example.add(idx3);
        example.add(idx4);
        example.add(idx5);
        String filename = "SocialRankings_test.txt";
        boolean actual = cashe.saveLocal(example, "wrongname");
        assertFalse(actual);
        actual = cashe.saveLocal(example, filename);
        assertTrue(actual);
    }

    @Test
    public void loadCashe() {
        ArrayList<ProcessingData.IndexRanking> actual = new ArrayList<>();
        String filename = "SocialRankings_test.txt";
        actual = cashe.loadCashe("WrongName");
        assertEquals(0, actual.size());
        actual = cashe.loadCashe(filename);
        assertEquals(5, actual.size());
        assertEquals("USA", actual.get(0).getCountry());
    }
}
