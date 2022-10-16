package project;


import java.util.Random;
/*
A Class for all objects in the Game so they all have XPosition, YPosition ,Height and width
 */
public abstract class FieldObject {

    private int xPos, yPos, height, width;
    public static Random rand = new Random();


    public FieldObject(int xPos, int yPos, int height, int width) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
        this.width = width;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
