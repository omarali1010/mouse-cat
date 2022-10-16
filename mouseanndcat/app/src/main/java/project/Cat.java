package project;
/*
A Class for the Cats   to determine how they will move and how they will follow the mouses

 */
public class Cat extends Pet {


    public Cat(int height, int width) {
        super(rand.nextInt(700), rand.nextInt(700), height, width);
    }


    /*
    IF the Mouse is hiding in his house (Cave) the Cat will move Randomly
     */
    public void RandomMove() {
        int random1 = rand.nextInt(2);
        int random2 = rand.nextInt(2);

        if (random1 == 1)
            this.setxPos(this.getxPos() + 1);

        else
            this.setxPos(this.getxPos() - 1);
        if (random2 == 1)
            this.setyPos(this.getyPos() + 1);
        else
            this.setyPos(this.getyPos() - 1);

    }

/*
   A Method so that the cat can follow the mouse (Or any Object)
 */
    public void follow(FieldObject FieldObject) {


        if (this.getxPos() < FieldObject.getxPos())
            this.setxPos(this.getxPos() + 1);
        else
            this.setxPos(this.getxPos() - 1);
        if (this.getyPos() < FieldObject.getyPos())
            this.setyPos(this.getyPos() + 1);
        else
            this.setyPos(this.getyPos() - 1);


    }


}
