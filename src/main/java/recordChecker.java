import java.util.ArrayList;


public class recordChecker {

    private final ArrayList<Double> mensRecords;
    private final ArrayList<Double> womensRecords;

    public recordChecker(ArrayList<Double> mensRecords, ArrayList<Double> womensRecords){
        this.mensRecords = mensRecords;
        this.womensRecords = womensRecords;
    }

    // method accepts an array of finish times and a boolean indicating whether to check for mens or women's records
    // method returns an array indicating which records were broken
    public boolean[] checkRecords(double[] times, boolean mens){
        // initializes array of broken records; 0 = record not broken, 1 = record broken.
        boolean[] brokenRecords = {false, false, false};
        ArrayList<Double> recordsToCheck;
        // determines whether to check for mens or women's records
        if (mens){
            recordsToCheck = this.mensRecords;
        } else{
            recordsToCheck = this.womensRecords;
        }

        // nested loop to determine if a time is faster than a world record.
        for (double time : times) {
            for (int i = 0; i < recordsToCheck.size(); i++) {
                if (time > recordsToCheck.get(i)) {
                    // if a time is faster than a world record then the corresponding index in brokenRecords is
                    // set to 1 indicating a record was broken.
                    brokenRecords[i] = true;
                }
            }
        }
        return brokenRecords;
    }
}
