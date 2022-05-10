package commands;

/**
 * Команда show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class ShowCommand extends Command {
    public ShowCommand() {
        super("show", " вывести в стандартный поток вывода все элементы коллекции");
    }
}
