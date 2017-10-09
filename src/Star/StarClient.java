package Star;
import java.util.Scanner;

public class StarClient {
    static int x, y, r, n;

    public static void main(String[] args) {
        System.out.print("Star radius (100-350):\t\t\t\t\t");
        r = scanner();
        while (r < 100 || r > 350) {
            System.out.println("Error!");
            r = scanner();
        }
        System.out.print("Coordinate x of star center (till 350):\t");
        x = scanner();
        while (x < r || x > 350) {
            System.out.println("Error");
            x = scanner();
        }
        System.out.print("Coordinate y of star center (till 350):\t");
        y = scanner();
        while (y < r || y > 350) {
            System.out.println("Error!");
            y = scanner();
        }
        Star.main();
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
