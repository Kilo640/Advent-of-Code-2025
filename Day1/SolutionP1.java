import java.io.*;
import java.util.*;

public class SolutionP1{
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
            String turn = safeFile.nextLine();
            System.out.print(dial + "+" + turn + " -> ");
            char direction = turn.charAt(0);
            int clicks = Integer.parseInt(turn.substring(1)) % 100; //100 clicks puts you right back where you were anyway

            switch(direction){
                case 'L':
                    dial -= clicks;
                    if(dial < 0){dial = 100 + dial;}
                    break;
                case 'R':
                    dial = (dial + clicks) % 100; //Only need remainder anyways
                    break;
                default: 
                    System.out.println("\nHAHAHAHA... REAAAAAAL FUNNY...");
                    return;
            }

            System.out.println(dial);
            if(dial == 0){zeros++;}
        }
        System.out.println("Password: " + zeros);
    }
}