package assignment3;

import assignment3.ex41.base.ex41;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test41 {

    @Test
    public void testReadInput() {
        ex41 forty1 = new ex41();
        File inputFile = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\exercise41_input.txt");

        List<String> expected = new ArrayList<>();
        expected.add("Ling, Mai");
        expected.add("Johnson, Jim");
        expected.add("Zarnecki, Sabrina");
        expected.add("Jones, Chris");
        expected.add("Jones, Aaron");
        expected.add("Swift, Geoffrey");
        expected.add("Xiong, Fong");

        List<String> actual = forty1.readInput(inputFile);

        assertEquals(expected, actual);
    }
}
