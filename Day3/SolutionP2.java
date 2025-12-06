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
        
        long sum = 0;
        for(char[] line = file.nextLine().toCharArray(); file.hasNextLine(); line = file.nextLine().toCharArray()){
            int[] battery = new int[line.length];
            int[] used = new int[battery.length];
            for(int i = 0; i < battery.length; i++){used[i] = battery.length;}
            for (int i = 0; i < battery.length; i++){battery[i] = line[i] - '0';}
            
            int[] cells = new int[12];
            for(int i = 0; i < battery.length; i++){
                for(int j = 0; j < 12; j++){
                    if(battery[i] > cells[j] && i < battery.length - 11 + j && used[i] > j){
                        cells[j] = battery[i];
                        used[i] = j;
                        for(int k = j + 1; k < 12; k++){
                            cells[k] = battery[i + k - j];
                            used[i + k - j] = k;
                        }
                        
                        break;
                    }
                }
            }

            long max = 0;
            for(int i = 0; i < 12; i++){max += cells[11 - i] * Math.pow(10, i);}
            sum += max;
            System.out.println(Arrays.toString(battery) + ": " + max);
        }
        System.out.println("Answer: " + sum);
    }
}