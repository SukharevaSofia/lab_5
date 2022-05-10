package data;

/**
 * Класс Coordinates
 */
public class Coordinates {
    private float x;
    private Integer y; //Поле не может быть null
    public Coordinates(float x, Integer y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "x : " + x + ", y : " + y;
    }
}