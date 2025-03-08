package behavioral.strategy;

import behavioral.strategy.levels.DifficultyLevelStrategy;

public class Game {
    private DifficultyLevelStrategy difficultyLevelStrategy;

    public Game(DifficultyLevelStrategy difficultyLevelStrategy) {
        this.difficultyLevelStrategy = difficultyLevelStrategy;
    }

    public void setDifficultyLevel(DifficultyLevelStrategy difficultyLevelStrategy) {
        this.difficultyLevelStrategy = difficultyLevelStrategy;
    }

    public void startGame() {
        difficultyLevelStrategy.modifyGameRules();
    }
}
