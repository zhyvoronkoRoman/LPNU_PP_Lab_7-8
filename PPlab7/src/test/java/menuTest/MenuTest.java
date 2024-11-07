package menuTest;

import Train.Train;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Menu.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;

    @BeforeEach
    public void setUp(){
    menu = new Menu();
    }

    @Test
    public void testCreateTrain() {
    menu.menu();
    ArrayList<Train> trains = menu.createTrain();
    assertEquals(6,trains.size());
    }

    @Test
    public void testInvalidOptionHandling() {
        assertEquals(5,menu.getCommands().size());
    }
}