import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class ClientTests {
    static private String[][] stdiotests = { { "00:01:15\nasSeconds\n", "75\n" }, { "75\nasTime\n", "00:01:15\n" },
            { "13:27:15\nadd\n1\n", "00:00:00\n" }, { "13:27:15\nadd\n00:00:02\n", "00:00:01\n" }, };

    static private ByteArrayOutputStream setIOstreams(String input) {
        // set stdin
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        // set stdout
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        return os;
    }

    @Test
    @Timeout(3) // 3 secs
    // @Timeout(value = 3000, unit = TimeUnit.MILLISECONDS) //3000 ms
    public void testCase0() {
        for (String[] test : stdiotests) {
            String input = test[0];
            String expected = test[1];
            ByteArrayOutputStream os = setIOstreams(input);
            Client.main(null); // call Main()
            assertEquals(expected, os.toString());
        }
    }

}
