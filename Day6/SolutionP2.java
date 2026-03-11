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
        
        ArrayList<ArrayList<Integer>> problems = new ArrayList<>();
        String str;
        for(str = file.nextLine(); Character.isDigit(str.replace(" ", "").charAt(0)); str = file.nextLine()){
            String[] data = str.split(" ");
            ArrayList<Integer> line = new ArrayList<>();
            for(String x : data){
                try {
                    line.add(Integer.valueOf(x));
                } catch (NumberFormatException e) {/*Why must they add more spaces than needed?*/}
            }
            problems.add(line);
        }

        System.out.println("Problems:");
        String[] operations = str.split("\\s+");
        long total = 0;
        for(int j = 0; j < problems.get(0).size(); j++){
            long answer = problems.get(0).get(j);
            System.out.print(problems.get(0).get(j) + " " + operations[j] + " ");
            for(int i = 1; i < problems.size(); i++){
                if(operations[j].equals("*")){answer *= problems.get(i).get(j);}
                else if(operations[j].equals("+")){answer += problems.get(i).get(j);}
                System.out.print(problems.get(i).get(j) + ((i < (problems.size() - 1)) ? (" " + operations[j]) : "") + " ");
            }
            System.out.println("= " + answer);
            total += answer;
        }
        System.out.println("Answer: " + total);
    }
}