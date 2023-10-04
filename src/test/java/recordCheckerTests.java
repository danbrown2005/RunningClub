import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

public class recordCheckerTests {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Mens time breaks all records")
    public void checkRecords_givenMensTimeThatBreaksAllRecords_ReturnAllTrue(){
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(10.0, 11.0, 11.5));
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {100.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, true);
        boolean[] expectedResult = {true, true, true};
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Mens time breaks world record")
    public void checkRecords_givenMensTimeThatBreaksWorldRecord_ReturnWorldTrue(){
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(10.0, 12.0, 12.0));
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, true);
        boolean[] expectedResult = {true, false, false};
        Assertions.assertArrayEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Mens time breaks euro record")
    public void checkRecords_givenMensTimeThatBreaksEuroRecord_ReturnEuroTrue(){
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(12.0, 10.0, 12.0));
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, true);
        boolean[] expectedResult = {false, true, false};
        Assertions.assertArrayEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Mens time breaks UK record")
    public void checkRecords_givenMensTimeThatBreaksUKRecord_ReturnUKTrue(){
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(12.0, 12.0, 10.0));
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, true);
        boolean[] expectedResult = {false, false, true};
        Assertions.assertArrayEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Mens time breaks no records")
    public void checkRecords_givenMensTimeThatBreaksNoRecords_ReturnAllFalse(){
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(12.0, 12.0, 12.0));
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, true);
        boolean[] expectedResult = {false, false, false};
        Assertions.assertArrayEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Womens time breaks all records")
    public void checkRecords_givenWomensTimeThatBreaksAllRecords_ReturnAllTrue(){
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(10.0, 10.0, 10.0));
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, false);
        boolean[] expectedResult = {true, true, true};
        Assertions.assertArrayEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Womens time breaks world record")
    public void checkRecords_givenWomensTimeThatBreaksWorldRecord_ReturnWorldTrue(){
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(10.0, 12.0, 12.0));
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, false);
        boolean[] expectedResult = {true, false, false};
        Assertions.assertArrayEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Womens time breaks euro record")
    public void checkRecords_givenWomensTimeThatBreaksEuroRecord_ReturnEuroTrue(){
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(12.0, 10.0, 12.0));
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, false);
        boolean[] expectedResult = {false, true, false};
        Assertions.assertArrayEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Womens time breaks UK record")
    public void checkRecords_givenWomensTimeThatBreaksUKRecord_ReturnUKTrue(){
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(12.0, 12.0, 10.0));
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, false);
        boolean[] expectedResult = {false, false, true};
        Assertions.assertArrayEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Womens time breaks no records")
    public void checkRecords_givenWomensTimeThatBreaksNoRecords_ReturnAllFalse(){
        ArrayList<Double> womensRecords = new ArrayList<>(Arrays.asList(20.0, 20.0, 20.0));
        ArrayList<Double> mensRecords = new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0));
        double[] times = {11.0};
        recordChecker checker = new recordChecker(mensRecords, womensRecords);
        boolean[] result = checker.checkRecords(times, false);
        boolean[] expectedResult = {false, false, false};
        Assertions.assertArrayEquals(expectedResult, result);
    }

}
