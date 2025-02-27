package rpg_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DummyTest {
    private static final int HEALTH = 100;
    private static final int XP = 50;

    private Dummy deadDummy;
    private Dummy aliveDummy;

    @BeforeEach
    void setUp() {
        this.deadDummy = new Dummy(0, XP);
        this.aliveDummy = new Dummy(HEALTH, XP);
    }

    @Test
    void testDummyThrowsWhenTakeAttackButIsDead() {
        assertThrows(IllegalStateException.class, () -> deadDummy.takeAttack(10));
    }

    @Test
    void testDummyTakesDamageCorrectly() {
        int damage = 1;

        aliveDummy.takeAttack(damage);

        assertEquals(HEALTH - damage, aliveDummy.getHealth());
    }

    @Test
    void testDummyGivesXPWhenKilled() {
        assertEquals(XP, deadDummy.giveExperience());
    }

    @Test
    void testDummyThrowsAndDoesntGiveXPWhenAlive() {
        assertThrows(IllegalStateException.class, () -> aliveDummy.giveExperience());
    }

}