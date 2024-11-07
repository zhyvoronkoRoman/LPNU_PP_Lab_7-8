package trainTest;

import Train.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Coaches.*;

import static org.junit.jupiter.api.Assertions.*;
    class TrainTest {
        private Train train;

        @BeforeEach
        void setUp() {
            train = new Train("Тестовий потяг");
            // Adding different types of coaches with predefined values
            Coach businessCoach = new BussinesCoach();
            Coach economyCoach = new EcoCoach();
            train.addCoach(businessCoach);
            train.addCoach(economyCoach);
        }

        @Test
        void testAddCoach() {
            assertEquals(2, train.getCoaches().size(), "Потяг має мати 2 вагони.");
        }

        @Test
        void testNumOfPassengers() {
            // Assuming BussinesCoach has 20 seats and EconomyCoach has 30 seats.
            int expectedPassengers = train.getCoaches().get(0).getNumberOfSeats() +
                    train.getCoaches().get(1).getNumberOfSeats();
            assertEquals(expectedPassengers, train.numofpass(), "Число пасажирів має збігатися з бажаним числом.");
        }

        @Test
        void testNumOfBaggage() {
            int expectedBags = (train.getCoaches().get(0).getNumOfBagsPerPerson() * train.getCoaches().get(0).getNumberOfSeats()) +
                    (train.getCoaches().get(1).getNumOfBagsPerPerson() * train.getCoaches().get(1).getNumberOfSeats());
            assertEquals(expectedBags, train.numofbagage(), "Число багажу має збігатися з бажаним числом.");
        }

        @Test
        void testSortCoaches() {
            train.sortCoaches();
            assertTrue(train.getCoaches().get(0).getComfLevel() <= train.getCoaches().get(1).getComfLevel(),
                    "Вагони мають бути посортовані за рівнем комфорту.");
        }

        @Test
        void testFindCoach() {
            // Redirecting System.out for testing output
            var outputStreamCaptor = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outputStreamCaptor));

            // Example input: we look for a coach with at least 20 seats
            train.findCoach(20);

            // Check output contains details of the coach that meets the condition
            assertTrue(outputStreamCaptor.toString().contains("BussinesCoach") || outputStreamCaptor.toString().contains("EconomyCoach"),
                    "Вивід має містити деталі про вагон.");
        }

        @Test
        void testToString() {
            String expectedString = "\nTest Train, Вагони:[BussinesCoach, EconomyCoach]";
            assertTrue(train.toString().contains("Test Train") && train.toString().contains("Вагони"),
                    "toString має містити інформацію про к-сть вагонів.");
        }
    }

