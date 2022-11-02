import org.junit.jupiter.api.Test;
import src.Game;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void run() {
        int temp = Game.run();
        assertEquals(1, temp);
    }
}