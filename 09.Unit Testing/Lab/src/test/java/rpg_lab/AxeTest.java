package rpg_lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;

    private Dummy dummy;
    private Axe axe;
    private Axe brokenAxe;

    @BeforeEach
    public void setUp() {
        this.dummy = new Dummy(100, 100);
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.brokenAxe = new Axe(AXE_ATTACK, 0);
    }

    @Test
    void testAxeLosesDurabilityAfterAttack() {
        axe.attack(dummy);
        assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test
    void testAxeThrowsWhenAttackingIfBroken() {
        assertThrows(IllegalStateException.class, () -> brokenAxe.attack(dummy));
    }
}