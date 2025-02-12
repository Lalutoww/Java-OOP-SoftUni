package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner.nextLine());
        int row = dimensions[0];
        int col = dimensions[1];

        Galaxy galaxy = new Galaxy(row, col);
        Jedi jedi;
        Evil evil;

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] jediCoords = readArray(command);
            int[] evilCoords = readArray(scanner.nextLine());

            evil = new Evil(evilCoords[0], evilCoords[1], galaxy);
            jedi = new Jedi(jediCoords[0], jediCoords[1], galaxy);

            evil.move();

            jedi.collectStars();

            command = scanner.nextLine();
        }

        System.out.println(Jedi.getStarsCollected());


    }

    private static int[] readArray(String data) {
        return Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
