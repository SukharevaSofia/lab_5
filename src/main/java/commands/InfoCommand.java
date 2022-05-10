package commands;

/**
 * Команда info : вывести в стандартный поток вывода информацию о коллекции
 * (тип, дата инициализации, количество элементов и т.д.)
 */
public class InfoCommand extends Command {
    public InfoCommand() {
        super("info", " вывести в стандартный поток вывода информацию о коллекции");
    }
}
