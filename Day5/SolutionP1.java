import java.io.*;
import java.util.*;

public class SolutionP1{
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
        for(String str = file.nextLine(); str.length() > 0; str = file.nextLine()){
            String[] data = str.split("-");
            long[] range = {Long.parseLong(data[0]), Long.parseLong(data[1])};
            ranges.add(range);
        }

        System.out.println("Ranges:");        
        for(long[] range : ranges){System.out.println(Arrays.toString(range));}
        System.out.println();

        int freshCount = 0;
        for(long current = Long.parseLong(file.nextLine()); file.hasNextLine(); current = Long.parseLong(file.nextLine())){
            boolean fresh = false;
            for(long[] range : ranges){
                if(current >= range[0] && current <= range[1]){
                    freshCount++;
                    System.out.println(current + ": fresh!");
                    fresh = true;
                    break;
                }
            }
            if(!fresh){System.out.println(current + ": spoiled!");}
        }
        System.out.println("Answer: " + freshCount);
    }
}