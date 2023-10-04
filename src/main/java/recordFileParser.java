import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class recordFileParser {

    // accepts a String file name
    // returns a ArrayList<Double> of world records
    public ArrayList<Double> fileParser(String fileName){

        ArrayList<Double> result = new ArrayList<>();

        // try catch loop to catch IException in the case of an invalid file name, returns empty records.
        // throws exception if invalid file name or invalid data in records file otherwise returns ArrayList<Double> of results.
        try(  Scanner reader = new Scanner(Paths.get(fileName))) {
            String[] records = reader.nextLine().split(",");
            for (String record : records){
                // checks if string can be safely converted into double will throw exception
                result.add(Double.valueOf(record));
            }
        }
        catch (IOException invalidFileName){
            System.out.println("Program terminating - Invalid file name. \n File Name - " + fileName);
            System.exit(1);
        } catch (Exception invalidData) {
            System.out.println("Program terminating - Invalid data in " + fileName);
            System.exit(1);
        }

        return result;
    }

}