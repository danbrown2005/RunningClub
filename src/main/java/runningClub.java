import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class runningClub {
    public static void main(String[] args) {
        String[] validGenders = {"M", "F"};
        Scanner inputScanner = new Scanner(System.in);
        inputValidator validator = new inputValidator();
        recordFileParser parser = new recordFileParser();
        ArrayList<Double> mensRecords = parser.fileParser("src/main/resources/mensWorldRecords.csv");
        ArrayList<Double> womensRecords = parser.fileParser("src/main/resources/womensWorldRecords.csv");
        recordChecker checker = new recordChecker(mensRecords, womensRecords);

        String gender;//
        do {
            System.out.println("Male or Female competitors? (M/F)");
            gender = inputScanner.nextLine().toUpperCase();
        }
        while (!validator.validateStringInput(gender.toUpperCase(), validGenders));
        String runners;
        do {
            System.out.println("Enter number of runners: 4-8 ");
            runners = inputScanner.nextLine();
        }
        while (!validator.validateIntegerInputWithinRange(runners, 4, 8));
        int runnerCount = Integer.parseInt(runners);
        System.out.println("There are " + runnerCount + " runners in the race.");

        double[] runningTimes = new double[runnerCount];

        for (int i = 0; i < runnerCount; i++) {
            String time;
            do {
                System.out.println("Please enter the time (m/s) for runner " + (i + 1) + ":");
                time = inputScanner.nextLine();
            }
            while (!validator.validateDoubleInput(time));
            runningTimes[i] = Double.parseDouble(time);
        }
        Arrays.sort(runningTimes);

        boolean[] recordsBroken;
        if (gender.equals("M")){
            recordsBroken = checker.checkRecords(runningTimes, true);
        }else{
            recordsBroken = checker.checkRecords(runningTimes, false);
        }

        for (int i = runningTimes.length - 1; i >= 0; i--){
            System.out.println((i - (runningTimes.length + 1))+": " + runningTimes[i] +  " m/s");
        }

        boolean recordBroken = false;
        if (recordsBroken[0]){
            System.out.println("World record broken.");
            recordBroken = true;
        }
        if (recordsBroken[1]){
            System.out.println("Euro record broken.");
            recordBroken = true;
        }
        if (recordsBroken[2]){
            System.out.println("British record broken.");
            recordBroken = true;
        }
        if (!recordBroken){
            System.out.println("No record's broken.");
        }


    }

}
