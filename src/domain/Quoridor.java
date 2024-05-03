package src.domain;

import java.awt.*;

public class Quoridor {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player winner;
    private boolean isGameOver;
    public Player getCurrentPlayer(){
        return  this.currentPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Quoridor() {
        this.player1 = new Player("Pedro", Color.BLUE,0,0);
        this.player2 = new Player("Juanita", Color.BLACK,8,8);
        this.currentPlayer = player2;
        this.board = new Board(player1,player2);

        this.winner = null;
        this.isGameOver = false;
    }

    public boolean turn(TypeMove typeMove, int x, int y) {
        if (typeMove == TypeMove.piecemove){
            if(!board.movePiece(x,y,currentPlayer)){
                return false;
            }
        }
        if(typeMove == TypeMove.wallHorizontalmove){
            if(!board.addHorizontalWall(x,y,currentPlayer)){
                return false;
            }
        }
        if(typeMove == TypeMove.wallVerticalmove){
            if(!board.addVerticalWall(x,y,currentPlayer)) {
                return false;
            }
        }
        switchPlayer();
        return true;
    }


    public void switchPlayer() {
        if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }

    }

    public void endGame() {
        // End the game
    }

    public void checkWinCondition() {
        // Check if a player has won
    }

    public void checkMoveValidity() {
        // Check if a move is valid
    }
}
