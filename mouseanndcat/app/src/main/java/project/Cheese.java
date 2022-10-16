package project;

/*
THe Cheese Class to make CHeese that can be eaten by the mouse
 */
public class Cheese extends FieldObject {

    private int numberofCheese = 0;

    public Cheese(int height, int width) {
        super(rand.nextInt(500), rand.nextInt(500), height, width);
    }

    public int getNumberofCheese() {
        return numberofCheese;
    }

    public void setNumberofCheese(int numberofCheese) {
        this.numberofCheese = numberofCheese;
    }

    // Just a Method to increase the Number Of Eaten Cheese by one
    public void eaten() {
        numberofCheese++;
    }

}
