import com.example.Gameboard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;




class MainTest {

    Gameboard gameboard = new Gameboard(5,5);
    @Test
    void makeSureGameBoardObjectIsNotEmpty(){

       assertNotNull(gameboard);
    }

    @Test
    void printOutGameBoard(){

        gameboard.printGameBoard();

        assertEquals(5,gameboard.getBoardWidth());
        assertEquals(5,gameboard.getBoardHeight());


    }
    @Test
    void addLivingCellsToGameBoard(){
        gameboard.addLivingCells(0,0);
        gameboard.addLivingCells(2,2);
        gameboard.addLivingCells(3,2);

        
        gameboard.printGameBoard();

        String count = Arrays.deepToString(gameboard.getBoard());
        System.out.println(count);

        assertThat(gameboard.cellExistWithinBoard(3,2)).isEqualTo(1);

    }

    @Test
    void checkAmountOfNearByLivingCells(){

        gameboard.addLivingCells(2,2);
        gameboard.addLivingCells(3,2);
        gameboard.addLivingCells(4,2);
        gameboard.printGameBoard();

        System.out.println(gameboard.getLivingCellsCloseBy(3,2));

         assertEquals(2 , gameboard.getLivingCellsCloseBy(3,2));
    }

    @Test
    void checkIfCellIsAlive(){
        gameboard.addLivingCells(2,2);
        assertThat(gameboard.cellExistWithinBoard(2,2)).isEqualTo(1);
    }

    @Test
    void checkIfCellIsDead(){
        gameboard.addLivingCells(2,2);
        gameboard.addLivingCells(3,2);
        gameboard.addLivingCells(4,2);
        gameboard.printGameBoard();

       gameboard.deleteLivingCells(4,2);

       boolean deadcell = gameboard.cellIsDead(4,2);
        assertThat(deadcell).isTrue();
        gameboard.printGameBoard();
    }
    @Test
    void genereateBoardWithNewGenerationOfCells(){

    }

}