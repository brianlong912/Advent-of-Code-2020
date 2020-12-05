import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day4 {
    public static void main(String[] args) {
        ArrayList<Passport> passports = new ArrayList<>();

        try {
            File input = new File("day4/day4-input.txt");
            Scanner s = new Scanner(input);
            s.useDelimiter("\n\n");

            while (s.hasNext()) {
                Passport temp = new Passport();
                passports.add(temp);

                temp.getFieldTitles(s.next().split("\\s+"));
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        int n = 0;
        for (int i = 0; i < passports.size(); i++) {
            Passport pass = passports.get(i);

            if (pass.hasAllFields()) {
                n++;
            }
        }
        System.out.println("Part 1: " + n);

        /* Part 2 */
        n = 0;
        for (int i = 0; i < passports.size(); i++) {
            Passport pass = passports.get(i);

            if (pass.hasAllFields() && pass.isValid()) {
                n++;
            }
        }
        System.out.println("Part 2: " + n);
    }
}
