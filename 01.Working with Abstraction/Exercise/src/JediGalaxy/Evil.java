package JediGalaxy;

public class Evil {
    private final Galaxy galaxy;
    private int evilRow;
    private int evilCol;

    public Evil(int evilRow, int evilCol, Galaxy galaxy) {
        this.evilRow = evilRow;
        this.evilCol = evilCol;
        this.galaxy = galaxy;
    }

    public void move() {

        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < galaxy.getGalaxy().length && evilCol < galaxy.getGalaxy()[0].length) {
                galaxy.getGalaxy()[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }
}
