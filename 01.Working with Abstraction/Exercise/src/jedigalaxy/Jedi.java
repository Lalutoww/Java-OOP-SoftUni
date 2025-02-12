package jedigalaxy;

public class Jedi {
    private static long starsCollected;
    private final Galaxy galaxy;
    private int jediRow;
    private int jediCol;

    public Jedi(int jediRow, int jediCol, Galaxy galaxy) {
        this.jediRow = jediRow;
        this.jediCol = jediCol;
        this.galaxy = galaxy;
    }

    public static long getStarsCollected() {
        return starsCollected;
    }

    public void collectStars() {

        while (jediRow >= 0 && jediCol < galaxy.getGalaxy()[1].length) {
            if (jediRow < galaxy.getGalaxy().length && jediCol >= 0 && jediCol < galaxy.getGalaxy()[0].length) {
                starsCollected += galaxy.getGalaxy()[jediRow][jediCol];
            }
            jediCol++;
            jediRow--;
        }
    }
}
