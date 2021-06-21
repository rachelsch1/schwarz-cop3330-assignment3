package assignment3;

import assignment3.ex43.base.ex43;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class Test43 {

    @Test
    public void testMainFolder() throws IOException {
        ex43 forty3 = new ex43();

        boolean expected = true;
        boolean actual = forty3.createMainFolder("name", "author");

        assertEquals(expected, actual);
    }

    @Test
    public void testJsFolder() throws IOException {
        ex43 forty3 = new ex43();

        boolean expected = true;
        boolean actual = forty3.createJsFolder("name");

        assertEquals(expected, actual);
    }

    @Test
    public void testCssFolder() throws IOException {
        ex43 forty3 = new ex43();

        boolean expected = true;
        boolean actual = forty3.createCssFolder("name");

        assertEquals(expected, actual);
    }
}
