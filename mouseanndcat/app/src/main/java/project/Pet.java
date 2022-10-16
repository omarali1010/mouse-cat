package project;

/*
A Class For Pets both Cats And Mouse to determine what they eat
 */
public abstract class Pet extends FieldObject {


    public Pet(int xPos, int yPos, int height, int width) {
        super(xPos, yPos, height, width);
    }


/*
Can be used for the Cat to eat the mouse
        or  for the Mouse to eat the Cheese
 */
    public boolean canEat(FieldObject FieldObject) {
        if ((this.getxPos() <= FieldObject.getxPos() + (FieldObject.getWidth())) && (this.getxPos() >= FieldObject.getxPos() - (FieldObject.getWidth()))) {
            if ((this.getyPos() <= FieldObject.getyPos() + (FieldObject.getHeight())) && (this.getyPos() >= FieldObject.getyPos() - (FieldObject.getHeight())))
                return true;
        }
        return false;
    }
}
