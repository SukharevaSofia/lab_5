package commands;

/**
 * Абстрактный класс для создания команд
 */
public abstract class Command{
    private String name;
    private String description;

    Command(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString(){
        return name + " : " + description;
    }
}
