package rpg_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {
    private static final int RETURNED_XP = 100;

    private Hero hero;
    private Target mockedTarget;

    @BeforeEach
    public void setUp() {
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        this.mockedTarget = Mockito.mock(Target.class);
        this.hero = new Hero("Kratos", mockedWeapon);
    }

    @Test
    void testUponTargetKillHeroGetsXP() {
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(RETURNED_XP);

        this.hero.attack(mockedTarget);
        assertEquals(RETURNED_XP, this.hero.getExperience());
    }

    @Test
    void testUponTargetAttackWhileTargetIsStillAliveHeroGetsNoXP() {
        Mockito.when(mockedTarget.isDead()).thenReturn(false);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(RETURNED_XP);

        this.hero.attack(mockedTarget);
        assertEquals(0, this.hero.getExperience());
    }
}