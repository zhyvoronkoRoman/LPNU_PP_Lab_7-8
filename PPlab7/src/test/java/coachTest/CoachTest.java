package coachTest;

import Coaches.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {
    @Test
    public void testBussinesCoachProperties() {
        BussinesCoach bussinesCoach = new BussinesCoach();
        assertEquals("Бізнес клас", bussinesCoach.getName());
        assertEquals(20, bussinesCoach.getNumberOfSeats());
        assertEquals(10, bussinesCoach.getNumOfBagsPerPerson());
        assertEquals(2000.0, bussinesCoach.getPrice());
        assertEquals(3, bussinesCoach.getComfLevel());
    }

    @Test
    public void testBussinesToString() {
        BussinesCoach bussinesCoach = new BussinesCoach();
        String expected = "Назва вагона  - Бізнес клас, К-сть місць - 20, К-сть сумок на особу - 10, Ціна - 2000.0грн Рівень комфортності 3;";
        assertEquals(expected, bussinesCoach.toString());
    }

    @Test
    public void testEcoCoachProperties() {
        EcoCoach ecoCoach = new EcoCoach();
        assertEquals("Економ", ecoCoach.getName());
        assertEquals(60, ecoCoach.getNumberOfSeats());
        assertEquals(2, ecoCoach.getNumOfBagsPerPerson());
        assertEquals(500.0, ecoCoach.getPrice());
        assertEquals(1, ecoCoach.getComfLevel());
    }

    @Test
    public void testEcoToString() {
        EcoCoach ecoCoach = new EcoCoach();
        String expected = "Назва вагона  - Економ клас, К-сть місць - 60, К-сть сумок на особу - 2, Ціна - 500.0грн Рівень комфортності 1";
        assertEquals(expected, ecoCoach.toString());
    }

    @Test
    public void testMidleCoachProperties() {
        MidleCoach midleCoach = new MidleCoach();
        assertEquals("Середній клас", midleCoach.getName());
        assertEquals(45, midleCoach.getNumberOfSeats());
        assertEquals(4, midleCoach.getNumOfBagsPerPerson());
        assertEquals(750.0, midleCoach.getPrice());
        assertEquals(2, midleCoach.getComfLevel());
    }

    @Test
    public void testMidleToString() {
        MidleCoach midleCoach = new MidleCoach();
        String expected = "Назва вагона  - Середній клас, К-сть місць - 45, К-сть сумок на особу - 4, Ціна - 750.0грн Рівень комфортності 2";
        assertEquals(expected, midleCoach.toString());
    }

    @Test
    public void testDifferentComfortLevels() {
        BussinesCoach bussinesCoach = new BussinesCoach();
        EcoCoach ecoCoach = new EcoCoach();
        MidleCoach midleCoach = new MidleCoach();

        assertTrue(bussinesCoach.getComfLevel() > ecoCoach.getComfLevel());
        assertTrue(midleCoach.getComfLevel() < bussinesCoach.getComfLevel());
    }
}
