package assignment3;

import assignment3.ex42.base.ex42;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Test42 {

    @Test
    public void testReadInput() {
        ex42 forty2 = new ex42();
        File inputFile = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\exercise42_input.txt");

        List<String[]> expected = new ArrayList<>();
        String[] arr1 = {"Ling", "Mai", "55900"};
        String[] arr2 = {"Johnson", "Jim", ""};
        String[] arr3 = {"Jones", "Aaron", "46000"};
        String[] arr4 = {"Jones", "Chris", "34500"};
        String[] arr5 = {"Swift", "Geoffrey", "14200"};
        String[] arr6 = {"Xiong", "Fong", "65000"};
        String[] arr7 = {"Zarnecki", "Sabrina", "51500"};
        expected.add(arr1);
        expected.add(arr2);
        expected.add(arr3);
        expected.add(arr4);
        expected.add(arr5);
        expected.add(arr6);
        expected.add(arr7);



        List<String[]> actual = forty2.readInput(inputFile);

        assertEquals(expected, actual);
    }
}
