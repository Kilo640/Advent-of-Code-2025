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
        
        int sum = 0;
        for(char[] line = file.nextLine().toCharArray(); file.hasNextLine(); line = file.nextLine().toCharArray()){
            int[] battery = new int[line.length];
            for (int i = 0; i < battery.length; i++){battery[i] = line[i] - '0';}
            
            int first = 0;
            int second = 0;
            for(int i = 0; i < battery.length; i++){
                if(battery[i] > first && i < battery.length - 1){
                    first = battery[i];
                    second = battery[i + 1];
                }else if(battery[i] > second){second = battery[i];}
            }

            int max = first * 10 + second;
            sum += max;
            System.out.println(Arrays.toString(battery) + ": " + max);
        }
        System.out.println("Answer: " + sum);
    }
}