package data;

/**
 * Класс BestAlbum
 */
public class BestAlbum {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long length; //Значение поля должно быть больше 0
    public BestAlbum(String name, long length){
        this.name = name;
        this.length = length;
    }
    @Override
    public String toString(){
        return "Name: " + name +
                "\nLength: " + length;
    }

}