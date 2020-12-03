import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day1 {
    public static void main(String[] args){
        int[] nums = new int[200];
        try {
            File input = new File("day1/day1-input.txt");
            Scanner s = new Scanner(input);
            int i = 0;
            while (s.hasNextLine()){
                nums[i] = Integer.parseInt(s.nextLine());
                i++;
            }
            s.close();
        } catch (FileNotFoundException e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if (nums[i]+nums[j] == 2020){
                    System.out.println(nums[i]*nums[j]);
                }
            }
        }
    }
}