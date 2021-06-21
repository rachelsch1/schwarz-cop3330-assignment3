package assignment3;


//One should never utilize the word "utilize" in writing. Use "use" instead.
//For example, "She uses an IDE to write her Java programs" instead of "She
//utilizes an IDE to write her Java programs".

import assignment3.ex45.base.ex45;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Test45 {
    @Test
    public void testReadInput() throws IOException {
        ex45 forty5 = new ex45();
        File inputFile = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\exercise45_input.txt");
        String path = "C:\\Users\\rachel\\Desktop\\code\\oop\\exercise45_input.txt";
        String expected = "One should never utilize the word \"utilize\" in writing. Use \"use\" instead. For example, \"She uses an IDE to write her Java programs\" instead of \"She utilizes an IDE to write her Java programs\".";

        String actual = forty5.readInput(inputFile, path);

        assertEquals(expected, actual);
    }

}

