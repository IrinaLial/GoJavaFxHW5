package SnowMan;
import java.util.Scanner;

public class SnowmanClient {
    static int count, min, max, n;

    public static void main(String[] args) {
        System.out.println("type please the quantity of circles from 2 to 8:");
        count = scanner();
        while (count > 8 || count < 2) {
            System.out.println("Error!");
            count = scanner();
        }
        System.out.println("Type min radius from 10 to 30");
        min = scanner();
        while (min > 30 || min < 10) {
            System.out.println("Error!");
            min = scanner();
        }
        System.out.println("Type max radius from 30 to 75");
        max = scanner();
        while (max > 75 || max < 30) {
            System.out.println("Error!");
            max = scanner();
        }
        Snowman.main();
    }

    public static int scanner() {
        Scanner s = new Scanner(System.in);
        while (s.hasNextInt()) {
            n = s.nextInt();
            break;
        }
        return n;
    }

}
