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
        
        ArrayList<char[]> map = new ArrayList<>();
        System.out.println("Map:");
        while(file.hasNextLine()){
            map.add(file.nextLine().toCharArray());
            System.out.println(Arrays.toString(map.getLast()));
        }
        System.out.println();

        int rolls = 0;
        for(int i = 0; i < map.size(); i++){
            for(int j = 0; j < map.get(i).length; j++){
                int adjCount = 0;
                if(map.get(i)[j] != '@'){continue;}

                int[][] adjIndexes = {{i-1,j-1}, {i+1,j-1}, {i-1,j+1}, {i+1,j+1}, {i,j-1}, {i-1,j}, {i,j+1}, {i+1,j}};
                for(int k = 0; k < 8; k++){
                    try {
                        if(map.get(adjIndexes[k][0])[adjIndexes[k][1]] == '@'){adjCount++;}
                    } catch(IndexOutOfBoundsException e) {}
                }
                if(adjCount < 4){
                    System.out.println("Roll Accessed: (" + i + "," + j + ")");
                    rolls++;
                }
            }
        }
        System.out.println("Answer: " + rolls);
    }
}