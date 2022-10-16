package project;

/*
      The house of the mouse where he can hide
 */
public class Cave extends FieldObject {


    public Cave(int height, int width) {
        super(rand.nextInt(300), rand.nextInt(300), height, width);
    }
}
