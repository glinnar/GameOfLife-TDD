import com.example.Gameboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    Gameboard gameboard = new Gameboard();
    @Test
    void testMain(){
        assertTrue(false);

    }
    @Test
    void makeSureGameBoardIsNotEmpty(){

       assertNotNull(gameboard);
    }

}