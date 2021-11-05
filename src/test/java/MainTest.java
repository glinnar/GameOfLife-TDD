import com.example.Gameboard;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    Gameboard gameboard = new Gameboard(5, 5);

    @Test
    void makeSureGameBoardObjectIsNotEmpty() {

        assertNotNull(gameboard);
    }

    @Test
    void printOutGameBoard() {

        gameboard.printGameBoard();

        assertEquals(5, gameboard.getBoardWidth());
        assertEquals(5, gameboard.getBoardHeight());


    }

    @Test
    void addLivingCellsToGameBoard() {
        gameboard.addLivingCells(0, 0);
        gameboard.addLivingCells(2, 2);
        gameboard.addLivingCells(3, 2);

        assertThat(gameboard.cellExistWithinBoard(3, 2)).isEqualTo(1);

    }

    @Test
    void checkThatAmountOfNearByLivingCellsIsCorrectShouldReturnTwo() {

        gameboard.addLivingCells(2, 2);
        gameboard.addLivingCells(3, 2);
        gameboard.addLivingCells(4, 2);

        assertEquals(2, gameboard.getLivingCellsCloseBy(3, 2));
    }

    @Test
    void checkIfCellIsAlive() {
        gameboard.addLivingCells(2, 2);
        gameboard.addLivingCells(3, 2);
        gameboard.addLivingCells(4, 2);

        assertThat(gameboard.cellIsAlive(2, 2)).isTrue();
    }

    @Test
    void checkIfCellIsDead() {
        gameboard.addLivingCells(2, 2);
        gameboard.addLivingCells(3, 2);
        gameboard.addLivingCells(4, 2);
        gameboard.printGameBoard();

        gameboard.deleteLivingCells(4, 2);

        boolean deadCell = gameboard.cellIsDead(4, 2);

        assertThat(deadCell).isTrue();
        gameboard.printGameBoard();
    }

    @Test
    void generateBoardWithNewGenerationOfCells() {

        gameboard.addLivingCells(2, 2);
        gameboard.addLivingCells(3, 2);
        gameboard.addLivingCells(4, 2);

        gameboard.printGameBoard();
        String firstGen = Arrays.deepToString(gameboard.getBoard());

        gameboard.generateNewGenerationOfCells();

        String secondGen = Arrays.deepToString(gameboard.getBoard());

        gameboard.printGameBoard();
        assertThat(secondGen).isNotEqualTo(firstGen);

    }

    @Test
    void checkThatGameBoardContainsCells() {
        gameboard.addLivingCells(4, 2);

        assertThat(gameboard.cellExistWithinBoard(4, 2)).isNotZero();
    }

    @Test
    void checkThatCellLivesOnToNextGeneration(){
        gameboard.addLivingCells(2, 2);
        gameboard.addLivingCells(3, 2);
        gameboard.addLivingCells(4, 2);

        gameboard.printGameBoard();

        gameboard.generateNewGenerationOfCells();

        gameboard.printGameBoard();

        assertThat(gameboard.cellIsAlive(3,2)).isTrue();

    }

    @Test
    void checkThatCellDiesNextGeneration(){
        gameboard.addLivingCells(2, 2);
        gameboard.addLivingCells(3, 2);
        gameboard.addLivingCells(4, 2);

        gameboard.addLivingCells(2, 4);

        gameboard.printGameBoard();

        gameboard.generateNewGenerationOfCells();

        gameboard.printGameBoard();

        assertThat(gameboard.cellIsDead(2,4)).isTrue();

    }


}