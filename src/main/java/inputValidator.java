

public class inputValidator {
    public boolean validateStringInput(String input, String[] validInputs){
        for (String validInput : validInputs){
            if (validInput.equalsIgnoreCase(input)){
                return true;
            }
        }
        System.out.println("Please enter a valid input.");
        return false;
    }

    public boolean validateIntegerInputWithinRange(String input, int minimum, int maximum) {
        try {
            int runnerCount = Integer.parseInt(input);
            if (runnerCount >= minimum && runnerCount <= maximum) {
                return true;
            } else{
                System.out.println("Please enter a valid number of runners.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid input.");
            return false;
        }
    }

    public boolean validateDoubleInput(String input) {
        try {
            double runnerCount = Double.parseDouble(input);
        } catch (Exception e) {
            System.out.println("Please enter a valid input.");
            return false;
        }
        return true;
    }
}
