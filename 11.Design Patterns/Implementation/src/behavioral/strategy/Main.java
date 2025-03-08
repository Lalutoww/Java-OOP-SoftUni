package behavioral.strategy;

import behavioral.strategy.levels.EasyLevel;
import behavioral.strategy.levels.HardLevel;
import behavioral.strategy.levels.MediumLevel;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new EasyLevel());
        game.startGame(); // Start the game on easy difficulty.

        game.setDifficultyLevel(new MediumLevel());
        game.startGame(); // Switch to medium difficulty.

        game.setDifficultyLevel(new HardLevel());
        game.startGame(); // Switch to hard difficulty.
    }
}
