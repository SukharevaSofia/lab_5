package commands;

/**
 * Команда count_greater_than_description description : вывести количество элементов,
 * значение поля description которых больше заданного
 */

public class CountDescriptionCommand extends Command {
    public CountDescriptionCommand() {
        super("count_greater_than_description", " вывести количество элементов, " +
                "значение поля description которых больше заданного");
    }
}
