package Tests;

import GOL.CellState;
import GOL.Coord;
import GOL.GameOfLife;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTest {
    @Test
    public void testCountingAliveNeighbors(){
        Coord[] aliveNeighbors = new Coord[] {
                new Coord(3,2),
                new Coord(3,3),
                new Coord(3,4),
                new Coord(2,2)
        };
        GameOfLife gol = new GameOfLife(5, 5, aliveNeighbors);
        int countNeighbors = gol.countlivingNeighbours(3,3);
        assertEquals(3, countNeighbors);

    }

    @Test
    public void testGridType(){
        Coord[] aliveNeighbors = new Coord[] {
                new Coord(3,2),
                new Coord(3,3),
                new Coord(3,4),
                new Coord(2,2)
        };
        GameOfLife gol = new GameOfLife(5, 5, aliveNeighbors);
        assertEquals(int[][].class, gol.grid.getClass());
    }

    @Test
    public void testGridSize(){
        Coord[] aliveNeighbors = new Coord[] {
                new Coord(3,2),
                new Coord(3,3),
                new Coord(3,4),
                new Coord(2,2)
        };
        GameOfLife gol = new GameOfLife(5, 5, aliveNeighbors);
        assertEquals(5, gol.grid.length);
        assertEquals(5, gol.grid[0].length);
    }

    @Test
    public void testAllCellsDead(){
        Coord[] aliveNeighbors = new Coord[] {};
        GameOfLife gol = new GameOfLife(5, 5, aliveNeighbors);
        for(int i = 0; i < gol.grid.length; i++){
            for(int j = 0; j < gol.grid[0].length; j++){
                assertEquals(CellState.DEAD, gol.grid[i][j]);
            }
        }
    }

    @Test
    public void testAreNegativeGridSize() {
        Coord[] aliveNeighbors = new Coord[] {
                new Coord(3,2),
                new Coord(3,3),
                new Coord(3,4),
                new Coord(2,2)
        };

        assertThrows(IllegalArgumentException.class, () -> {
            GameOfLife gol = new GameOfLife(-5, -5, aliveNeighbors);
        });
    }

}