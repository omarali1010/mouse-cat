package project;

import java.util.ArrayList;

/*
A Class where all Objects interact with each other
 */
public class World implements Cloneable {

    private int inc = 2;
    private Mouse mouse = new Mouse(30, 30);
    private Cheese cheese = new Cheese(30, 30);
    private Cave cave = new Cave(50, 50);
    private ArrayList<Cat> cats = new ArrayList<>();

    public void setInc(int inc) {
        this.inc = inc;
    }

    public World() {
        cats.add(new Cat(50, 50));
    }


    //A Funtion to determine if One of the Cats Maneged to eat the Mouse
    public boolean isGameOver() {

        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).canEat(mouse))
                return true;
        }

        return false;


    }

    public void increaseCats() {

        if ((cheese.getNumberofCheese() == inc)) {


            cats.add(new Cat(50 + inc * 5, 50 + inc * 5));
            inc = cheese.getNumberofCheese() + 2;
        }


    }

    // A Function to determine How the Cat will move according to the mouse appearance
    public void catMoving() {


        if (mouse.hideout(cave)) {
            for (int i = 0; i < cats.size(); i++) {
                cats.get(i).RandomMove();
            }
        } else {
            for (int i = 0; i < cats.size(); i++) {
                cats.get(i).follow(mouse);
            }
        }
    }


    public Mouse getMouse() {

        return mouse;
    }


    public Cheese getCheese() {
        return cheese;
    }

    public Cave getCave() {
        return cave;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }
}
