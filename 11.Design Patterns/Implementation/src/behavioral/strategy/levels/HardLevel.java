package behavioral.strategy.levels;

public class HardLevel implements DifficultyLevelStrategy {
    @Override
    public void modifyGameRules() {
        System.out.println("Game rules for hard level: Time limit reduced, complex scoring.");
    }
}
