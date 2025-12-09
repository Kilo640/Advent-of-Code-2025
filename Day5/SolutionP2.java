import java.io.*;
import java.util.*;

public class SolutionP2{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        Scanner file = null;
        boolean fileFound = false;
        
        System.out.print("Enter Input File: ");
        while(!fileFound){
            try {
                file = new Scanner(new File(console.nextLine()));
                fileFound = true;
            } catch (FileNotFoundException bruh) {
                System.out.print("Invalid file! Enter Input File: ");
            }
        }
        
        ArrayList<long[]> ranges = new ArrayList<>();
        //Actually had to get creative here, brute force took too long!
        for(String str = file.nextLine(); str.length() > 0; str = file.nextLine()){
            String[] data = str.split("-");
            long[] range = {Long.parseLong(data[0]), Long.parseLong(data[1])};
            boolean isSubset = false;

            for(int i = 0; i < ranges.size(); i++){
                long[] currRange = ranges.get(i);
                if(currRange[0] >= range[0] && currRange[1] <= range[1]){ //    |----| <-- currRange
                    ranges.remove(i); i--;                                // |----------| <-- range
                }else if(currRange[0] <= range[0] && currRange[1] >= range[1]){// |----------| <-- currRange
                    isSubset = true;                                           //    |----| <-- range
                }else if(currRange[0] <= range[1] && currRange[1] >= range[1]){ //    |-------| <-- currRange   
                    ranges.remove(i); i--;                                      // |----| <-- range
                    range[1] = currRange[1];
                }else if(currRange[1] >= range[0] && currRange[0] <= range[0]){ // |-----| <-- currRange
                    ranges.remove(i); i--;                                      //     |-----| <-- range
                    range[0] = currRange[0];
                }
            }
            if(!isSubset){ranges.add(range);}
        }

        System.out.println("Ranges:");   
        long rangeTotal = 0;     
        for(long[] range : ranges){
            System.out.println(Arrays.toString(range));
            rangeTotal += range[1] - range[0] + 1;
        }

        System.out.println("Answer: " + rangeTotal);
    }
}