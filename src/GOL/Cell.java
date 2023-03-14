package GOL;

public class Cell {
    public int state;
    public int livingNeighbors;

    public Cell(int state, int livingNeighbors){
        this.state = state;
        this.livingNeighbors = livingNeighbors;
    }

    /**
     * Given an initial state for the cell, computes its next state
     * @return
     */
    public int NextState(){
        if(state == CellState.ALIVE && (livingNeighbors == 2 || livingNeighbors == 3)) {
            return CellState.ALIVE;
        }

        if(state == CellState.DEAD && livingNeighbors == 3) {
            return CellState.ALIVE;
        }

        return CellState.DEAD;
    }
}
