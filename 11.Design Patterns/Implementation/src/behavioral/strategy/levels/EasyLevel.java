package behavioral.strategy.levels;

public class EasyLevel implements DifficultyLevelStrategy {
    @Override
    public void modifyGameRules() {
        System.out.println("Game rules for easy level: Time limit increased, scoring simplified.");
    }
}