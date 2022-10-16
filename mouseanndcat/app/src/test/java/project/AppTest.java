
package project;

import junit.framework.AssertionFailedError;
import org.junit.Test;

import static org.junit.Assert.*;


class AppTest {

    World world = new World();


    @org.junit.jupiter.api.Test
    void isGameOver() {

        assertFalse(world.isGameOver());

    }

    @org.junit.jupiter.api.Test
    void followSmaller() {
        world.getCats().get(0).setxPos(100);
        world.getCats().get(0).setyPos(100);
        world.getMouse().setxPos(50);
        world.getMouse().setyPos(50);
        world.getCats().get(0).follow(world.getMouse());
        assertEquals(String.format("The cat Cant follow The Mouse when the mouse has smaller X Positions"),world.getCats().get(0).getxPos(), 994) ;
        assertEquals(String.format("The cat Cant follow The Mouse when the mouse has smaller y Positions"),world.getCats().get(0).getyPos(), 99);


    }
    @org.junit.jupiter.api.Test
    void followBigger() {
        world.getCats().get(0).setxPos(100);
        world.getCats().get(0).setyPos(100);
        world.getMouse().setxPos(288);
        world.getMouse().setyPos(288);
        world.getCats().get(0).follow(world.getMouse());
        assertEquals(String.format("The cat Cant follow The Mouse when the mouse has bigger X Positions"),world.getCats().get(0).getxPos(), 101);
        assertEquals(String.format("The cat Cant follow The Mouse when the mouse has bigger y Positions"),world.getCats().get(0).getyPos(), 101);

    }

    @org.junit.jupiter.api.Test
    void followDiffValues() {
        world.getCats().get(0).setxPos(100);
        world.getCats().get(0).setyPos(100);
        world.getMouse().setxPos(50);
        world.getMouse().setyPos(200);
        world.getCats().get(0).follow(world.getMouse());

        assertEquals(String.format("The cat Cant follow The Mouse when the mouse has smaller X Positions"),world.getCats().get(0).getxPos(), 99);
        assertEquals(String.format("The cat Cant follow The Mouse when the mouse has bigger Y Positions"),world.getCats().get(0).getyPos(), 101);

        world.getMouse().setxPos(200);
        world.getMouse().setyPos(50);
        world.getCats().get(0).follow(world.getMouse());

        assertEquals(String.format("The cat Cant follow The Mouse when the mouse has bigger X Positions"),world.getCats().get(0).getxPos(), 100);
        assertEquals(String.format("The cat Cant follow The Mouse when the mouse has smaller Y Positions"),world.getCats().get(0).getyPos(), 100);


    }

    @org.junit.jupiter.api.Test
    void Mouse_Position() {

        assertNotEquals(String.format("The mouse is out of the Field"),-100, world.getMouse().getxPos());
        assertNotEquals(String.format("The mouse is out of the Field"),800, world.getMouse().getxPos());
        assertNotEquals(String.format("The mouse is out of the Field"),-100, world.getMouse().getyPos());
        assertNotEquals(String.format("The mouse is out of the Field"),800, world.getMouse().getyPos());


    }


    @org.junit.jupiter.api.Test
    void testIsGameOVerDefault() {

        assertFalse(String.format("THe Game over Method is True even the Game didnt Start Yet"),world.isGameOver());
    }

    @org.junit.jupiter.api.Test
    void testIsGameOVerMouse() {
        world.getCats().get(0).setxPos(100);
        world.getCats().get(0).setyPos(100);
        world.getMouse().setxPos(100);
        world.getMouse().setyPos(100);
        assertTrue(String.format("THe Game over Method should be true but its not working"),world.isGameOver());

    }

    @org.junit.jupiter.api.Test
    void testcheese() {
        world.getCheese().eaten();
        assertEquals(String.format("The Number of Cheese in not Increasing"),1, world.getCheese().getNumberofCheese());
        world.getCheese().eaten();
        world.getCheese().eaten();
        assertEquals(String.format("The Number of Cheese in not Increasing"),3, world.getCheese().getNumberofCheese());
        assertNotEquals(String.format("The Number of Cheese is having a Negative Value"),-1, world.getCheese().getNumberofCheese());
    }


    @org.junit.jupiter.api.Test
    void MouseandChesse() {
        int numOfCheese = world.getCheese().getNumberofCheese();
        world.getCheese().setxPos(100);
        world.getCheese().setyPos(100);
        world.getMouse().setxPos(100);
        world.getMouse().setyPos(100);
        if (world.getMouse().canEat(world.getCheese())){
            world.getCheese().eaten();
            assertEquals(String.format("The MOuse ate the Cheese but its number is not increasing"),numOfCheese + 1, world.getCheese().getNumberofCheese());

        }


    }

    @org.junit.jupiter.api.Test
    void NumOfCats() {
        world.getCheese().setNumberofCheese(0);
        world.getCheese().eaten();
        assertEquals(String.format("Number of Cats is not Increasing "),1,world.getCats().size());
        world.getCheese().eaten();
        world.increaseCats();
        assertEquals(String.format("Number of Cats is not Increasing "),2,world.getCats().size());
        world.getCheese().eaten();
        world.increaseCats();
        assertEquals(String.format("Number of Cats is not Increasing "),2,world.getCats().size());
        world.getCheese().eaten();
        world.increaseCats();
        assertEquals(String.format("Number of Cats is not Increasing "),3,world.getCats().size());



    }

    @org.junit.jupiter.api.Test
    void CatSize() {
        world.getCheese().setNumberofCheese(0);
        world.getCheese().eaten();
        assertEquals(String.format("the height of the Cat is not as specified in the code"),50,world.getCats().get(0).getHeight());
        world.getCheese().eaten();
        world.increaseCats();
        assertEquals(String.format("the height of the cat is not getting bigger "),50+5*world.getCheese().getNumberofCheese(),world.getCats().get(1).getHeight());
        world.getCheese().eaten();
        world.getCheese().eaten();
        world.increaseCats();
        assertEquals(String.format("the height of the cat is not getting bigger "),50+5*world.getCheese().getNumberofCheese(),world.getCats().get(2).getHeight());



    }

}

