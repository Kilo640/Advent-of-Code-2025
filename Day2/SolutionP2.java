import java.io.*;
import java.util.*;

public class SolutionP2{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        Scanner idFile = null;
        boolean fileFound = false;
        
        System.out.print("Enter Input File: ");
        while(!fileFound){
            try {
                idFile = new Scanner(new File(console.nextLine()));
                fileFound = true;
            } catch (FileNotFoundException bruh) {
                System.out.print("Invalid file! Enter Input File: ");
            }
        }
        
        String[] data = idFile.nextLine().split(",");
        long[][] ranges = new long[data.length][2];
        int i = 0;
        for(String range : data){
            String[] point = range.split("-");
            ranges[i][0] = Long.parseLong(point[0]);
            ranges[i][1] = Long.parseLong(point[1]);
            i++;
        }

        long sum = 0;
        for(long[] range : ranges){
            ArrayList<Long> invalids = new ArrayList<>();
            for(long id = range[0]; id <= range[1]; id++){
                String idString = Long.toString(id);
                boolean invalid = false;
                if(id < 10){continue;}

                for(int step = 1; step <= idString.length() / 2 && !invalid; step++){
                    if (idString.length() % step > 0){continue;}

                    String search = idString.substring(0,step);
                    boolean mismatch = false;
                    for(i = step; i <= (idString.length() - step) && !mismatch; i += step){
                        mismatch = !search.equals(idString.substring(i, i + step));
                    }

                    invalid = !mismatch;
                }
                if(invalid){     
                    invalids.add(id);
                    sum += id;
                }
            }
            System.out.println(Arrays.toString(range) + ": " + invalids);
        }
        System.out.println("Answer: " + sum);
    }
}