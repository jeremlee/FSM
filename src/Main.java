//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] transitions = {
                {1,4,8,2,2,2,2,2,2,2,1}, //0
                {1,1,1,1,1,1,1,1,1,1,1}, //1
                {3,3,3,3,3,3,3,3,3,3,7}, //2
                {1,1,1,1,1,1,1,1,1,1,7}, //3
                {5,5,5,5,5,5,5,5,5,5,7}, //4
                {6,6,6,6,6,6,6,6,6,6,7}, //5
                {1,1,1,1,1,1,1,1,1,1,7}, //6
                {25,16,19,14,14,14,14,14,14,14,1}, //7
                {9,9,9,9,9,11,13,13,13,13,7}, //8
                {10,10,10,10,10,10,10,10,10,10,7}, //9
                {1,1,1,1,1,1,1,1,1,1,7}, //10
                {12,12,12,12,12,12,1,1,1,1,7}, //11
                {1,1,1,1,1,1,1,1,1,1,7}, //12
                {1,1,1,1,1,1,1,1,1,1,7}, //13
                {15,15,15,15,15,15,15,15,15,15,1}, //14
                {1,1,1,1,1,1,1,1,1,1,1}, //15
                {17,17,17,17,17,17,17,17,17,17,1}, //16
                {18,18,18,18,18,18,18,18,18,18,1}, //17
                {1,1,1,1,1,1,1,1,1,1,1}, //18
                {20,20,20,20,20,22,24,24,24,24,1}, //19
                {21,21,21,21,21,21,21,21,21,21,1}, //20
                {1,1,1,1,1,1,1,1,1,1,1}, //21
                {23,23,23,23,23,23,1,1,1,1,1}, //22
                {1,1,1,1,1,1,1,1,1,1,1}, //23
                {1,1,1,1,1,1,1,1,1,1,1}, //24
                {1,1,1,1,1,1,1,1,1,1,1}, //25
        }; //first 10 columns are inputs from 0-9, and 11th column is for "."
        int[] acceptingStates = {14,15,16,17,18,19,20,21,22,23,24,25};
        System.out.print("Enter IPv2 address: ");
        String ip = scanner.nextLine();
        int state = 0;
        for(int i=0;i<ip.length();i++){
            if(!(Character.isDigit(ip.charAt(i))) && ip.charAt(i) != '.')  throw new RuntimeException("Invalid string");
            if(ip.charAt(i) == '.') state = transitions[state][10];
            else state = transitions[state][ip.charAt(i) - '0'];
            System.out.println("Character: " + ip.charAt(i) + " || State: " + state);
        }
        boolean isValid = false;
        for(int i=0;i<acceptingStates.length;i++){
            if(state == acceptingStates[i]){
                isValid = true;
                break;
            }
        }
        if(isValid) System.out.println("Valid");
        else System.out.println("Invalid");
    }
}