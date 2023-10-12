package comp301.inclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlphabetizerTest {

    @Test
    public void simpleTest() {
        String[] test_data = {"kappa", "alpha", "gamma"};
        String[] inorder = {"alpha", "gamma", "kappa"};

        Alphabetizer iter = new Alphabetizer(test_data);
        int count = 0;
        while (iter.hasNext()) {
            String s = iter.next();
            assertEquals(inorder[count], s);
            count++;
        }
        assertEquals(3, count);
    }

    @Test
    public void withDuplicatesTest() {
        String[] test_data = {"kappa", "alpha", "gamma", "alpha", "kappa", "kappa"};
        String[] inorder =   {"alpha", "alpha", "gamma", "kappa", "kappa", "kappa"};

        Alphabetizer iter = new Alphabetizer(test_data);
        int count = 0;
        while (iter.hasNext()) {
            String s = iter.next();
            assertEquals(inorder[count], s);
            count++;
        }
        assertEquals(test_data.length, count);
    }

}
