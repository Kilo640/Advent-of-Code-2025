import java.io.*;
import java.util.*;

public class SolutionP1{
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
                if(idString.substring(0,idString.length() / 2).equals(idString.substring(idString.length() / 2))){
                    invalids.add(id);
                    sum += id;
                }
            }
            System.out.println(Arrays.toString(range) + ": " + invalids);
        }
        System.out.println("Answer: " + sum);
    }
}