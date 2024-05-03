package src.domain;

import java.awt.*;

public class Player {
    private String name;
    private int walls;
    private int x;
    private int y;
    private Color playerColor;

    public Player(String name, Color playerColor,int x,int y) {
        this.name = name;
        this.walls = 3;
        this.playerColor = playerColor;
        this.x = x;
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    public int getWalls() {
        return walls;
    }
    public void setWalls() {
        this.walls -=1;
    }

    public void decreaseWalls() {
        // Decrease the player's walls
    }

    public void increaseWalls() {
        // Increase the player's walls
    }

    public Color getPlayerColor() {

        return playerColor;
    }

    public int getX() { return this.x;}
    public int getY() { return this.y;}
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(Board board) {
        // Move the player
    }
    @Override
    public  String toString(){
        return name +" le quedan:" + walls;
    }
}
