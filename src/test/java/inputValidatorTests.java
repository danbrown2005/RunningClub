import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class inputValidatorTests {
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
    @DisplayName("Lowercase valid string supplied")
    public void validateStringInput_givenLowercaseValidString_returnTrue() {
        inputValidator validator = new inputValidator();
        String[] validStrings = {"A", "B"};
        boolean result = validator.validateStringInput("b", validStrings);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Uppercase valid string supplied")
    public void validateStringInput_givenUppercaseValidString_returnTrue() {
        inputValidator validator = new inputValidator();
        String[] validStrings = {"A", "B"};
        boolean result = validator.validateStringInput("B", validStrings);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Lowercase invalid string supplied")
    public void validateStringInput_givenLowercaseValidString_returnFalse() {
        inputValidator validator = new inputValidator();
        String[] validStrings = {"A", "B"};
        boolean result = validator.validateStringInput("c", validStrings);
        String consoleOutput = outContent.toString().trim();
        Assertions.assertFalse(result);
        Assertions.assertEquals("Please enter a valid input.", consoleOutput);
    }

    @Test
    @DisplayName("Uppercase invalid string supplied")
    public void validateStringInput_givenUppercaseValidString_returnFalse() {
        inputValidator validator = new inputValidator();
        String[] validStrings = {"A", "B"};
        boolean result = validator.validateStringInput("C", validStrings);
        String consoleOutput = outContent.toString().trim();
        Assertions.assertFalse(result);
        Assertions.assertEquals("Please enter a valid input.", consoleOutput);

    }

    @Test
    @DisplayName("Valid Integer within range")
    public void validateIntegerInputWithinRange_givenValidIntegerWithinRange_returnTrue() {
        inputValidator validator = new inputValidator();
        boolean result = validator.validateIntegerInputWithinRange("5", 0, 10);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Valid Integer outside range")
    public void validateIntegerInputWithinRange_givenValidIntegerOutsideRange_returnFalse() {
        inputValidator validator = new inputValidator();
        boolean result = validator.validateIntegerInputWithinRange("11", 0, 10);
        String consoleOutput = outContent.toString().trim();
        Assertions.assertFalse(result);
        Assertions.assertEquals("Please enter a valid number of runners.", consoleOutput);
    }

    @Test
    @DisplayName("Invalid Integer within range")
    public void validateIntegerInputWithinRange_givenInvalidIntegerWithinRange_returnFalse() {
        inputValidator validator = new inputValidator();
        boolean result = validator.validateIntegerInputWithinRange("55.5", 0, 10);
        String consoleOutput = outContent.toString().trim();
        Assertions.assertFalse(result);
        Assertions.assertEquals("Please enter a valid input.", consoleOutput);
    }

    @Test
    @DisplayName("Invalid Integer outside range")
    public void validateIntegerInputWithinRange_givenInvalidIntegerOutsideRange_returnFalse() {
        inputValidator validator = new inputValidator();
        boolean result = validator.validateIntegerInputWithinRange("11A", 0, 10);
        String consoleOutput = outContent.toString().trim();
        Assertions.assertFalse(result);
        Assertions.assertEquals("Please enter a valid input.", consoleOutput);
    }

    @Test
    @DisplayName("Valid double")
    public void validateDoubleInput_givenValidDouble_returnTrue() {
        inputValidator validator = new inputValidator();
        boolean result = validator.validateDoubleInput("55.5");
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Invalid double")
    public void validateDoubleInput_givenInvalidDouble_returnFalse() {
        inputValidator validator = new inputValidator();
        boolean result = validator.validateDoubleInput("Fifty");
        String consoleOutput = outContent.toString().trim();
        Assertions.assertFalse(result);
        Assertions.assertEquals("Please enter a valid input.", consoleOutput);
    }


}
