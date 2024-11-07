package commandTest;

import Coaches.BussinesCoach;
import Menu.*;
import Train.Train;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {
    private ArrayList<Train> trains;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        trains = new ArrayList<>();
        Train testTrain = new Train("Тестовий потяг");
        testTrain.addCoach(new BussinesCoach());
        trains.add(testTrain);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testCountNumOfBaggageCommand() {
        // Імітація введення "1" для вибору першого потягу
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        CountNumOfBaggageCommand command = new CountNumOfBaggageCommand(trains, new java.util.Scanner(System.in));
        command.execute();

        // Очікуване значення багажу для першого потягу
        assertTrue(outputStreamCaptor.toString().contains("200"));
    }

    @Test
    public void testCountNumOfPassengersCommand() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        CountNumOfPassengersCommand command = new CountNumOfPassengersCommand(trains, new java.util.Scanner(System.in));
        command.execute();

        // Очікуване значення кількості пасажирів для першого потягу
        assertTrue(outputStreamCaptor.toString().contains("20"));
    }

    @Test
    public void testFindCoachByPassCommand() {
        System.setIn(new ByteArrayInputStream("99\n".getBytes()));

        FindCoachByPassCommand command = new FindCoachByPassCommand(trains, new java.util.Scanner(System.in));
        command.execute();

        // Перевірка, що знайдений потяг відображено у виводі
        assertTrue(outputStreamCaptor.toString().contains("Тестовий потяг"));
    }

    @Test
    public void testSortCoachByComfortCommand() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));

        SortCoachByComfortCommand command = new SortCoachByComfortCommand(trains, new java.util.Scanner(System.in));
        command.execute();

        // Перевірка, що сортування відбулося успішно за рівнем комфорту
        assertEquals(3, trains.get(0).getCoaches().get(0).getComfLevel());
    }

    @Test
    public void testInvalidTrainSelection() {
        System.setIn(new ByteArrayInputStream("99\n".getBytes()));

        CountNumOfPassengersCommand command = new CountNumOfPassengersCommand(trains, new java.util.Scanner(System.in));
        command.execute();

        // Перевірка на відсутність результатів, оскільки вибрано неіснуючий потяг
        assertTrue(outputStreamCaptor.toString().contains("Не знайдено"));
    }
}
