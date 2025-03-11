package garage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GarageTests {
    Garage garage;
    Car car;

    @BeforeEach
    public void prepare() {
        garage = new Garage("LSC", 10);
        car = new Car("Zentorno", 800, "Purple");
    }

    @Test
    void testSetNameThrowsExceptionWhenNameIsEmptyOrNull() {
        assertThrows(NullPointerException.class, () -> new Garage("", 10));
        assertThrows(NullPointerException.class, () -> new Garage(null, 10));
        assertThrows(NullPointerException.class, () -> new Garage("  ", 10));
    }

    @Test
    void testSetCapacityThrowsExceptionWhenCapacityIsLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> new Garage("ILLEGAL_CAPACITY", -1));
    }

    @Test
    void testAddCarThrowsExceptionWhenGarageIsFull() {
        Garage singleSpaceGarage = new Garage("1 SPACE LEFT", 1);
        singleSpaceGarage.addCar(car);

        assertThrows(IllegalArgumentException.class, () -> singleSpaceGarage.addCar(new Car("TestCar", 100, "red")));
    }

    @Test
    void testAddCarThrowsExceptionWhenAddingAnExistingCar() {
        garage.addCar(car);
        assertThrows(IllegalArgumentException.class, () -> garage.addCar(car));
    }

    @Test
    void testAddCarAddsCarToGarage() {
        garage.addCar(car);
        assertEquals(1, garage.getCount());
        garage.addCar(new Car("secondCar", 1000, "black"));
        assertEquals(2, garage.getCount());
    }

    @Test
    void testRemoveCarReturnsFalseIfNoVehicleIsFound() {
        garage.addCar(car);
        assertEquals(1, garage.getCount());
        assertFalse(garage.removeCar("NON_EXISTING_CAR"));
        assertEquals(1, garage.getCount());
    }

    @Test
    void testRemoveCarSuccessfullyRemovesTheVehicle() {
        garage.addCar(car);
        assertEquals(1, garage.getCount());
        assertTrue(garage.removeCar(car.getBrand()));
        assertEquals(0, garage.getCount());
    }

    @Test
    void testGetMostPowerfulCarThrowsAssertionErrorWhenGarageIsEmpty() {
        assertThrows(AssertionError.class, () -> garage.getMostPowerfulCar());
    }

    @Test
    void testGetMostPowerfulCarReturnsTheCarWithMostHorsepower() {
        Car mostPowerfulCar = new Car("MOST_POWERFUL_CAR", Integer.MAX_VALUE, "Black");
        garage.addCar(car);
        garage.addCar(mostPowerfulCar);
        assertEquals(mostPowerfulCar.getBrand(), garage.getMostPowerfulCar());
    }

    @Test
    void testGetCarsWithDesiredColorsReturnsAnEmptyListWhenNoCarsAreMatched() {
        garage.addCar(car);
        assertTrue(garage.getCarsWithDesiredColor("Pink").isEmpty());
    }

    @Test
    void testGetCarsWithDesiredColorsReturnsListWithAllCarsWithDesiredColor() {
        Car greenCar1 = new Car("greenCar1", 140, "Green");
        Car greenCar2 = new Car("greenCar2", 140, "Green");
        garage.addCar(car);
        garage.addCar(greenCar1);
        garage.addCar(greenCar2);
        List<Car> expectedList = new ArrayList<>(Arrays.asList(greenCar1, greenCar2));
        assertEquals(2, expectedList.size());
        assertArrayEquals(expectedList.toArray(), garage.getCarsWithDesiredColor("Green").toArray());
    }

    @Test
    public void testGetCount() {
        assertEquals(0, garage.getCount());
        garage.addCar(car);
        assertEquals(1, garage.getCount());
    }

    @Test
    public void testGetName() {
        assertEquals("LSC", garage.getName());
    }

    @Test
    public void testSetName() {
        garage.setName("New Garage");
        assertEquals("New Garage", garage.getName());
    }

    @Test
    public void testGetCapacity() {
        assertEquals(10, garage.getCapacity());
    }

    @Test
    public void testSetCapacity() {
        garage.setCapacity(5);
        assertEquals(5, garage.getCapacity());
    }

    @Test
    public void testSetNameRenamesGarageIfInputIsValid() {
        garage = new Garage("Test Garage", 10);
        String newName = "New Garage Name";

        garage.setName(newName);
        assertEquals(newName, garage.getName(), "Garage name should be updated to the new name.");
    }
}


