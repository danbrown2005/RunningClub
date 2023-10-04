import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class runningClubTests {

    @Mock
    private recordFileParser parser;

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        // Configure your parser mock as needed
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }

    @Test
    public void testRunningClub_MaleRunners_NoRecordsBroken() {
        // Provide the input through a ByteArrayInputStream
        String input = "M\n4\n10.5\n11.0\n11.2\n11.4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        when(parser.fileParser("src/main/resources/mensWorldRecords.csv"))
                .thenReturn(new ArrayList<>(Arrays.asList(20.0, 20.0, 20.5)));
        when(parser.fileParser("src/main/resources/womensWorldRecords.csv"))
                .thenReturn(new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0)));

        runningClub.main(new String[]{});

        // Capture the console output
        String consoleOutput = outputStream.toString().trim();

        // Assertions for console output
        assertEquals("No record's broken.", consoleOutput);
    }

    // Add more test cases as needed

}
