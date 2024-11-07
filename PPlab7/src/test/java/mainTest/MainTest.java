package mainTest;

import Main.Main;
import Menu.Menu;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class MainTest {
    @Test
    void testMainExecution() {
        Menu mockMenu = mock(Menu.class);
        Main.main(new String[]{});
        verify(mockMenu, times(1)).menu();
    }
}
