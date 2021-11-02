import com.example.Gameboard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;




class MainTest {

    Gameboard gameboard = new Gameboard(10,10);
    @Test
    void makeSureGameBoardObjectIsNotEmpty(){

       assertNotNull(gameboard);
    }

    @Test
    void printOutGameBoard(){

        gameboard.printGameBoard();

        assertEquals(10,gameboard.getBoardWidth());
        assertEquals(10,gameboard.getBoardHeight());


    }
    @Test
    void addLivingCellsToGameBoard(){
        gameboard.addCells(0,0);
        gameboard.addCells(2,2);
        gameboard.addCells(3,2);
        gameboard.addCells(4,2);
        gameboard.addCells(4,9);
        gameboard.addCells(5,1);
        gameboard.addCells(6,2);

        //assertNotNull(gameboard.getBoard());
        gameboard.printGameBoard();

        String count = Arrays.deepToString(gameboard.getBoard());
        System.out.println(count);

        assertThat(gameboard.getBoard()).isNotEmpty();

       // assertThat(cellCount).isEqualTo(0);
    }

    @Test
    void checkAmountofAliveCellsMatchesCellsCreated(){

        gameboard.addCells(2,2);
        gameboard.addCells(3,2);
        gameboard.addCells(4,2);
        gameboard.printGameBoard();

        System.out.println(gameboard.getLivingCellsAmount(3,2));

         assertEquals(2 , gameboard.getLivingCellsAmount(3,2));
    }

}