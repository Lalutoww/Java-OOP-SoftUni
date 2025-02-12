package jedigalaxy;

public class Galaxy {
    private final int row;
    private final int col;
    int[][] galaxy;

    public Galaxy(int row, int col) {
        this.row = row;
        this.col = col;
        this.galaxy = this.fillGalaxy();
    }

    private int[][] fillGalaxy() {
        galaxy = new int[row][col];
        int value = 0;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                galaxy[i][j] = value++;
            }
        }
        return galaxy;
    }

    public int[][] getGalaxy() {
        return galaxy;
    }
}
