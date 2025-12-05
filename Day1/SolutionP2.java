import java.io.*;
import java.util.*;

public class SolutionP2{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        Scanner safeFile = null;
        boolean fileFound = false;
        
        System.out.print("Enter Input File: ");
        while(!fileFound){
            try {
                safeFile = new Scanner(new File(console.nextLine()));
                fileFound = true;
            } catch (FileNotFoundException bruh) {
                System.out.print("Invalid file! Enter Input File: ");
            }
        }

        int zeros = 0;
        int dial = 50;
        
        while(safeFile.hasNextLine()){
            int turnZeros = 0;
            String turn = safeFile.nextLine();
            System.out.print(dial + "+" + turn + " -> ");
            char direction = turn.charAt(0);
            int clicks = Integer.parseInt(turn.substring(1));
            turnZeros += clicks / 100; //Guess I have to count them now
            clicks %= 100;

            switch(direction){
                case 'L':
                    int lastDial = dial; //Edge case if going left from a 0
                    dial -= clicks;
                    if(dial < 0){
                        dial = 100 + dial;
                        if(lastDial > 0){turnZeros++;}
                    }
                    break;
                case 'R':
                    dial += clicks;
                    if(dial > 99){ //nvm then
                        dial %= 100;
                        if(dial > 0){turnZeros++;} //Can't double count!
                    }
                    break;
                default: 
                    System.out.println("\nHAHAHAHA... REAAAAAAL FUNNY...");
                    return;
            }

            if(dial == 0){turnZeros++;}
            System.out.println(dial + " (+" + turnZeros +")");
            zeros += turnZeros; 
        }
        System.out.println("Password: " + zeros);
    }
}