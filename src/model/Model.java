package model;

/**
 * Created by lollipop on 02.09.2016.
 */
public class Model {
    private Cell[][] cell = new Cell[9][9];
    private int countOfBombs = 0;

    public Model() {
        restart();
    }

    private void findNumberOfBombs() {
        int count = 0;
        for (int i = 0; i < this.cell.length; i++){
            for (int j = 0; j < this.cell[i].length; j++) {
                if (cell[i][j].isBomb()) count++;
            }
        }
        countOfBombs = count;
    }

    public int getCountOfBombs() {
        return countOfBombs;
    }

    public void fillCells() {
        int random;
        for (int i = 0; i < this.cell.length; i++){
            for (int j = 0; j < this.cell[i].length; j++) {
                Cell cell = new Cell();
                random = (int) (Math.random() * 9);
                if (random == 0) {
                    cell.setBomb(true);
                }
                this.cell[i][j] = cell;
            }
        }
        findNumberOfBombs();
    }

    public void restart() {
        fillCells();
        setCellNumbers();
    }
    public Cell[][] getCell() {
        return cell;
    }

    public void setCellNumbers(){
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell[i].length; j++) {
                cell[i][j] = setCellNumber(cell[i][j]);
            }
        }

    }
    private Cell setCellNumber(Cell cell) {
        int cellNumber = 0;
        if (cell.isBomb()) return cell;
        for (int i = 0; i < this.cell.length; i++) {
            for (int j = 0; j < this.cell[i].length; j++) {
                if (this.cell[i][j] == cell) {
                    if (i + 1 != this.cell.length && j + 1 != this.cell[i].length && this.cell[i + 1][j + 1].isBomb()) {
                        cellNumber++;
                    }
                    if (i + 1 != this.cell.length && j != 0 && this.cell[i + 1][j - 1].isBomb()) {
                        cellNumber++;
                    }
                    if (i != 0 && j + 1 != this.cell[i].length && this.cell[i - 1][j + 1].isBomb()) {
                        cellNumber++;
                    }
                    if (i != 0 && j != 0 && this.cell[i - 1][j - 1].isBomb()) {
                        cellNumber++;
                    }
                    if (j + 1 != this.cell[i].length && this.cell[i][j + 1].isBomb()) {
                        cellNumber++;
                    }
                    if (j != 0 && this.cell[i][j - 1].isBomb()) {
                        cellNumber++;
                    }
                    if (i + 1 != this.cell.length && this.cell[i + 1][j].isBomb()) {
                        cellNumber++;
                    }
                    if (i != 0 && this.cell[i - 1][j].isBomb()) {
                        cellNumber++;
                    }
                    cell.setBombsNumber(cellNumber);
                    return cell;
                }
            }
        }
        return null;
    }

}
