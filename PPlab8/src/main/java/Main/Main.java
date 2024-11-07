package Main;
import Menu.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Запуск програми.");
        try {
        Menu menu = new Menu();
    menu.menu();
        } catch (Exception e) {
            logger.error("Критична помилка у програмі.", e);
        }

        logger.info("Програма завершена.");
    }
}