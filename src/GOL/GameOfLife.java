package GOL;
import java.util.Arrays;

public class GameOfLife {

    private int rowCount;
    private int columnCount;

    public int[][] grid;

    public GameOfLife(int rowCount, int columnCount, Coord[] coords) {
        if (rowCount <= 0 || columnCount <= 0) {
            throw new IllegalArgumentException("Invalid grid size");
        }
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        Init();
        setLivingCells(coords);
    }

    /**
     * Minimalistic printing method for the grid : TODO improve if you want
     */
    public void PrintGrid(){
        for(int i = 0; i < rowCount; i++){
            for(int j = 0; j < columnCount; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    /**
     * Given a list of coordinates, sets the initial living cells
     * @param coords : List of coordinates indicating the position of the initial living cells
     */
    public void setLivingCells(Coord[] coords){
        for(Coord coord : coords) {
            setLivingCell(coord.x, coord.y);
        }

        System.out.println("Initialized grid with living cells");
        PrintGrid();
    }

    /**
     *  Given a row and a column number, sets the corresponding cell to a living state
     * @param row
     * @param column
     */
    public void setLivingCell(int row, int column) {
        grid[row][column] = CellState.ALIVE;
    }

    /**
     * Computes the nth next generation of the grid (i.e. updates all the cells states)
     * @param n Number or iteration to be executed
     */
    public void ComputeNthGeneration(int n){
        for(int i = 1; i <= n; i++) {
            System.out.println("Computing generation num." + i);
            computeNextGeneration();
        }
    }

    /**
     * Initialize the grid with dead cells
     */
    public void Init(){
        grid = new int [rowCount][columnCount];
        for (int y = 0; y < this.rowCount; y++) {
            Arrays.fill(grid[y], CellState.DEAD);
        }
    }

    /**
     * For a given cell, returns the number or adjacent living neighbors
     * @param row cell row
     * @param column cell column
     * @return the number of living neighbors
     */
    public int countlivingNeighbours(int row, int column) {
        int[][] cellsToCheck = {
                {row - 1, column - 1},
                {row - 1, column},
                {row - 1, column + 1},
                {row, column + 1},
                {row + 1, column + 1},
                {row + 1, column},
                {row + 1, column - 1},
                {row, column - 1},
        };
        int livingNeighbours = 0;
        for (int i = 0; i < cellsToCheck.length; i++) {
            int rowToCheck = cellsToCheck[i][0];
            int colTocheck = cellsToCheck[i][1];
            if (isInTheGrid(rowToCheck, colTocheck)) {
                livingNeighbours+= grid[rowToCheck][colTocheck];
            }
        }
        return livingNeighbours;
    }

    /**
     * Indicates wether some coordinates are in the grid boundaries
     * @param row
     * @param col
     * @return
     */
    private boolean isInTheGrid(int row, int col) {
        return row >= 0 && col >= 0 && row < rowCount && col < columnCount;
    }

    /**
     * Computes the next generation for the grid
     */
    public void computeNextGeneration() {
        int[][] nextGenerationGrid = new int[rowCount][columnCount];
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < columnCount; col++) {
                int livingNeighbours = countlivingNeighbours(row, col);
                int cellCurrentState = grid[row][col];
                Cell cell = new Cell(cellCurrentState, livingNeighbours);

                nextGenerationGrid[row][col] = cell.NextState();
            }
        }
        grid = nextGenerationGrid.clone();
        PrintGrid();
    }
}
