import com.example.Gameboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class MainTest {

    Gameboard gameboard = new Gameboard(20,20);
    @Test
    void makeSureGameBoardObjectIsNotEmpty(){

       assertNotNull(gameboard);
    }

    @Test
    void printOutGameBoard(){

        gameboard.printGameBoard();

    }

}