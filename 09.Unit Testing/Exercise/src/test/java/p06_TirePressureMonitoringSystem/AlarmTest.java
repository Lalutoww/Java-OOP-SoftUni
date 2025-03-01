package p06_TirePressureMonitoringSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlarmTest {
    private static final double LOW_PRESSURE = 12.0;
    private static final double HIGH_PRESSURE = 30.0;
    private static final double NORMAL_PRESSURE = 18.0;

    private static final Sensor sensor = Mockito.mock(Sensor.class);
    private static Alarm alarm;

    @BeforeEach
    public void setUp() {
        alarm = new Alarm(sensor);
    }

    @Test
    void testAlarmShouldReturnTrueWhenPressureValueIsLessThanLowestThreshold() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    void testAlarmShouldReturnTrueWhenPressureValueIsBiggerThanHighestThreshold() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE);
        alarm.check();
        assertTrue(alarm.getAlarmOn());
    }

    @Test
    void testAlarmCheckShouldReturnFalseWhenPressureValueIsNormal() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }

    @Test
    void testSensorRandomValue() {
        alarm = new Alarm(new Sensor());
        alarm.check();
    }
}