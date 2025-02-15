package randomarraylist;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<String> randomList = new RandomArrayList<>();

        for (int i = 0; i < 10; i++) {
            randomList.add("Random element " + i);
        }

        System.out.println("Removed random element is: " + randomList.getRandomElement());
        System.out.println("Removed random element is: " + randomList.getRandomElement());
        System.out.println("Removed random element is: " + randomList.getRandomElement());
    }
}
