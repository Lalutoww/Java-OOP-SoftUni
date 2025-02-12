package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rank = sc.nextLine();
        String suit = sc.nextLine();

        Card card = new Card(rank, suit);
        System.out.println(card);
    }
}
