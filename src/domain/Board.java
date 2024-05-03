package src.domain;

import java.awt.*;

public class Board {
    private int[][] boardcells;
    private int [][] boardVerticalcell;
    private int [][] boardHorizontalcell;
    private int size;
    private Player player1;
    private Player player2;

    public int[][] getBoardcells() {
        return boardcells;
    }
    public int[][] getBoardVerticalcell() {
        return boardVerticalcell;
    }
    public int[][] getBoardHorizontalcell() {
        return boardHorizontalcell;
    }

    public Board(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.boardcells = new int[9][9];
        this.boardHorizontalcell = new int[9][9];
        this.boardVerticalcell = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                boardcells[i][j] = 0;
                boardHorizontalcell[i][j] = 0;
                boardVerticalcell[i][j] = 0;
            }
        }
        boardcells[0][0] = 1;
        boardcells[8][8] = 2;
        player1.setX(0);
        player1.setY(0);
        player2.setX(8);
        player2.setY(8);
    }
    //movePiece devuelve true cuando se efectuo el moviento, false cuando no se pudo efectuar el movimiento
    public boolean movePiece(int x,int y,Player player) {

        if(player1 ==player){
            if(isvalidMove(x,y,1)){
                boardcells[player1.getX()][player1.getY()] = 0;
                boardcells[x][y] = 1;
                player1.setX(x);
                player1.setY(y);
                return true;
            }}
        else if (player2 == player) {
            if(isvalidMove(x,y,2)){
                boardcells[player2.getX()][player2.getY()] = 0;
                boardcells[x][y] = 2;
                player2.setX(x);
                player2.setY(y);
                return true;
            }
            }
        return false;

    }
    private boolean isvalidMove(int row,int col, int playernumber){
        // Verificar si la celda está en el borde izquierdo y hay una celda a la derecha en rojo
        if (col > 0 && boardcells[row][col-1] == playernumber && boardcells[row][col] ==0) {
            if(boardVerticalcell[row][col-1] != 1) {
                return true;
            }
        }
        // Verificar si la celda está en el borde derecho y hay una celda a la izquierda en rojo
        if (col < boardcells[row].length - 1 && boardcells[row][col + 1] == playernumber && boardcells[row][col] ==0) {
            if(boardVerticalcell[row][col] != 1) {
                return true;
            }
        }
        // Verificar si la celda está en el borde superior y hay una celda abajo en rojo
        if (row > 0 && boardcells[row - 1][col] == playernumber && boardcells[row][col] ==0) {
            if(boardHorizontalcell[row-1][col] != 1) {
                return true;
            }
        }
        // Verificar si la celda está en el borde inferior y hay una celda arriba en rojo
        if (row < boardcells.length - 1 && boardcells[row + 1][col] == playernumber && boardcells[row][col] ==0) {
            if(boardHorizontalcell[row][col] != 1) {
                return true;
            }
        }
        return false;
    }
    public boolean addHorizontalWall(int x, int y,Player player){
        if(this.boardHorizontalcell[x].length-1 <= y || this.boardHorizontalcell[x][y+1]== 1|| this.boardHorizontalcell[x][y] == 1 || player.getWalls()<1){
            return false;
        }
        this.boardHorizontalcell[x][y] = 1;
        this.boardHorizontalcell[x][y+1] = 1;
        player.setWalls();
        return true;
    }
    public boolean addVerticalWall(int x, int y,Player player){
        if(x >= this.boardVerticalcell.length - 1 || this.boardVerticalcell[x + 1][y] == 1 || this.boardVerticalcell[x][y] == 1|| player.getWalls() < 1)
        {
            return false;
        }
        this.boardVerticalcell[x][y] = 1;
        this.boardVerticalcell[x+1][y] = 1;
        player.setWalls();
        return true;
    }

}
