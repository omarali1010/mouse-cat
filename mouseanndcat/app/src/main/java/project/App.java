package project;

import processing.core.PApplet;
import processing.core.PImage;

/*
THe class that uses Processing
 */
public class App extends PApplet implements Logic {
    PImage catImg, mouseImg, houseImg, cheeseImg;
    int len = 1000;
    boolean[] keys = new boolean[128];

    public static void main(String[] args) {
        String[] appArgs = {"Mouse and Cat"};
        App mySketch = new App();
        PApplet.runSketch(appArgs, mySketch);

    }


    public void settings() {

        size(len, len);
    }

    public void setup() {

        background(255, 255, 255);
        textt("Welcome to My Game : Cat and Mouse", 0, height / 2, width, 50, color(0), 30, CENTER);
        textt("Play with", 0, (height / 2) +50, width, 50, color(0), 30, CENTER);
        textt("W", 0, (height / 2) +100, width, 50, color(0), 30, CENTER);
        textt("A S D ", 0, (height / 2) +150, width, 50, color(0), 30, CENTER);
        textt("Keys", 0, (height / 2) +200, width, 50, color(0), 30, CENTER);
        delay(1000);
        frameRate(600);
        mouseImg = loadImage("mouse.jpg");
        cheeseImg = loadImage("cheese.jpg");
        houseImg = loadImage("house.jpg");
        catImg = loadImage("cat.jpg");
    }

    public void draw() {
        background(244, 244, 244);

        move();
        follow();
        world.increaseCats();
        for (int i = 0; i < world.getCats().size(); i++) {
            image(catImg, world.getCats().get(i).getxPos(), world.getCats().get(i).getyPos(), world.getCats().get(i).getWidth(), world.getCats().get(i).getHeight());

        }

        image(mouseImg, world.getMouse().getxPos(), world.getMouse().getyPos(), world.getMouse().getWidth(), world.getMouse().getHeight());

        image(houseImg, world.getCave().getxPos(), world.getCave().getyPos(), world.getCave().getWidth(), world.getCave().getHeight());

        image(cheeseImg, world.getCheese().getxPos(), world.getCheese().getyPos(), world.getCheese().getWidth(), world.getCheese().getHeight());

        fill(230, 13, 122);
        textt("SCORE :" + world.getCheese().getNumberofCheese(), 20, 20, 200, 200, color(0), 20, LEFT);
        if (world.getMouse().canEat(world.getCheese())) {
            world.getCheese().setxPos(FieldObject.rand.nextInt(500));
            world.getCheese().setyPos(FieldObject.rand.nextInt(500));
            world.getCheese().setNumberofCheese(1 + world.getCheese().getNumberofCheese());
            print(world.getCheese().getNumberofCheese());
            world.getCave().setxPos(FieldObject.rand.nextInt(500));
            world.getCave().setyPos(FieldObject.rand.nextInt(500));
        }


    }
/*
 A function to determine how the Player will move
 */
    public void move() {
        if (keys['a']) {
            if (world.getMouse().getxPos() >= 0)
                world.getMouse().setxPos(world.getMouse().getxPos() - 2);
        }

        if (keys['d'])
            if (world.getMouse().getxPos() <= len - world.getMouse().getHeight())
                world.getMouse().setxPos(world.getMouse().getxPos() + 2);
        if (keys['w'])
            if (world.getMouse().getyPos() >= 0)
                world.getMouse().setyPos(world.getMouse().getyPos() - 2);
        if (keys['s'])
            if (world.getMouse().getyPos() <= len - world.getMouse().getHeight())

                world.getMouse().setyPos(world.getMouse().getyPos() + 2);
    }

    public void keyPressed() {
        keys[key] = true;
    }

    public void keyReleased() {
        keys[key] = false;
    }
/*

A Function that lets the cat follow the mouse if the Game is not Over
 */
    public void follow() {

        if (world.isGameOver() && !world.getMouse().hideout(world.getCave())) {

            rectt(0, 0, width, height, 0, color(200));
            textt("Your Score is : "+ world.getCheese().getNumberofCheese(), 0, (height / 2), width, 50, color(0), 30, CENTER);

            textt("GG click to play again ", 0, (height / 2)-100, width, 50, color(0), 30, CENTER);



            world.setInc(2);

            if (mousePressed || keyPressed) {
                world.getMouse().setxPos(FieldObject.rand.nextInt(700));

                world.getMouse().setyPos(FieldObject.rand.nextInt(700));

                for (int i = 0; i < world.getCats().size(); i++) {
                    world.getCats().get(i).setxPos(FieldObject.rand.nextInt(700));
                    world.getCats().get(i).setyPos(FieldObject.rand.nextInt(700));

                }

                world.getCats().clear();
                world.getCats().add(new Cat(50, 50));

                world.getCheese().setNumberofCheese(0);
            }
        } else {
            world.catMoving();

        }

    }

    void rectt(float x, float y, float w, float h, float r, int c) {
        fill(c);
        rect(x, y, w, h, r);
    }

    void textt(String t, float x, float y, float w, float h, int c, float s, int al) {
        fill(c);
        textAlign(al);
        textSize(s);
        text(t, x, y, w, h);
    }

}