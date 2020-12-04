import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        boolean[][] slope = new boolean[323][31]; // Map of the slope, true means tree at location

        try {
            File input = new File("day3/day3-input.txt");
            Scanner s = new Scanner(input);
            int n = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '.') {
                        slope[n][i] = false;
                    } else {
                        slope[n][i] = true;
                    }
                }
                n++;
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        int x, y;
        int n1, n2, n3, n4, n5;
        x = y = 0;
        n1 = n2 = n3 = n4 = n5 = 0;

        /* Slope of down 1, right 3 */
        while (y < slope.length) {
            if (slope[y][x]) {
                n1++;
            }
            y++;
            x = (x + 3) % slope[0].length;
        }
        System.out.println("Part 1: " + n1);

        /* Slope of down 1, right 1 */
        x = y = 0;
        while (y < slope.length) {
            if (slope[y][x]) {
                n2++;
            }
            y++;
            x = (x + 1) % slope[0].length;
        }
        System.out.println("Right 1, down 1: " + n2);

        /* Slope of down 1, right 5 */
        x = y = 0;
        while (y < slope.length) {
            if (slope[y][x]) {
                n3++;
            }
            y++;
            x = (x + 5) % slope[0].length;
        }
        System.out.println("Right 5, down 1: " + n3);

        /* Slope of down 1, right 7 */
        x = y = 0;
        while (y < slope.length) {
            if (slope[y][x]) {
                n4++;
            }
            y++;
            x = (x + 7) % slope[0].length;
        }
        System.out.println("Right 7, down 1: " + n4);

        /* Slope of down 2, right 1 */
        x = y = 0;
        while (y < slope.length) {
            if (slope[y][x]) {
                n5++;
            }
            y += 2;
            x = (x + 1) % slope[0].length;
        }
        System.out.println("Right 1, down 2: " + n5);
        long n = (long)n1 * n2 * n3 * n4 * n5;
        System.out.println("Part 2: " + n);
    }
}
