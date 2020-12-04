import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        Password[] passwords = new Password[1000];

        try {
            File input = new File("day2/day2-input.txt");
            Scanner s = new Scanner(input);
            int i = 0;
            while (s.hasNextLine()) {
                Password temp = new Password();
                String line = s.nextLine();

                String policy = line.split(":")[0];
                temp.pass = line.split(":")[1].trim();

                String range = policy.split(" ")[0];
                temp.c = policy.split(" ")[1].charAt(0);

                temp.rangeStart = Integer.parseInt(range.split("-")[0]);
                temp.rangeEnd = Integer.parseInt(range.split("-")[1]);

                passwords[i] = temp;
                i++;
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        int n = 0;

        for (int i = 0; i < passwords.length; i++) {
            Password password = passwords[i];
            int occurances = 0;
            for (int j = 0; j < password.pass.length(); j++) {
                if (password.pass.charAt(j) == password.c) {
                    occurances++;
                }
            }
            if (password.rangeStart <= occurances && occurances <= password.rangeEnd) {
                n++;
            }
        }
        System.out.println("Part 1: " + n);

        n = 0;
        for (int i = 0; i < passwords.length; i++) {
            Password password = passwords[i];
            if ((password.pass.charAt(password.rangeStart-1) == password.c)
                    ^ (password.pass.charAt(password.rangeEnd-1) == password.c)) {
                n++;
            }
        }
        System.out.println("Part 2: " + n);
    }

}
