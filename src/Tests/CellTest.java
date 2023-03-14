package Tests;

import GOL.Cell;
import GOL.CellState;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    public void testAliveCellState3Neighbors() {
        Cell cell = new Cell(CellState.ALIVE, 3);
        assertEquals(CellState.ALIVE, cell.NextState());
    }

    @Test
    public void testAliveCellState4Neighbors() {
        Cell cell = new Cell(CellState.ALIVE, 4);
        assertEquals(CellState.DEAD, cell.NextState());
    }

    @Test
    public void testDeadCellState3Neighbors() {
        Cell cell = new Cell(CellState.DEAD, 3);
        assertEquals(CellState.ALIVE, cell.NextState());
    }

    @Test
    public void testDeadCellState4Neighbors() {
        Cell cell = new Cell(CellState.DEAD, 4);
        assertEquals(CellState.DEAD, cell.NextState());
    }
}