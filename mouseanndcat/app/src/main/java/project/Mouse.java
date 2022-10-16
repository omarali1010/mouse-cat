package project;

/*
A class for the Mouse
 */
public class Mouse extends Pet {


    public Mouse(int height, int width) {

        super(rand.nextInt(500), rand.nextInt(500), height, width);
    }


    public boolean hideout(FieldObject FieldObject) {

        if ((this.getxPos() <= FieldObject.getxPos() + (FieldObject.getWidth() / 2)) && (this.getxPos() >= FieldObject.getxPos() - (FieldObject.getWidth() / 2))) {
            if ((this.getyPos() <= FieldObject.getyPos() + (FieldObject.getHeight() / 2)) && (this.getyPos() >= FieldObject.getyPos() - (FieldObject.getHeight() / 2)))
                return true;
        }

        return false;
    }

}
